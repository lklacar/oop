package com.lukaklacar.oop.data;

import com.lukaklacar.oop.config.Config;
import com.lukaklacar.oop.model.AbstractModel;
import com.lukaklacar.oop.util.FileUtil;
import lombok.val;
import lombok.var;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class EntityManager<T extends AbstractModel> {

    @Inject // Field injection so we don't have to override the constructor in subclasses
    private Config config;

    @SuppressWarnings("unchecked")
    private Class<T> getGenericType() {
        val superClass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) superClass.getActualTypeArguments()[0];
    }

    public List<T> findAll() {
        return FileUtil.getFileLines(getDataFile())
                .stream()
                .map(line -> deserialize(line.split(config.getDelimiter())))
                .collect(Collectors.toList());
    }

    public void save(T entity) {
        var all = findAll();
        all.add(entity);
        FileUtil.overrideFile(getDataFile(),
                all
                        .stream()
                        .map(en -> StringUtils.join(this.serialize(en), config.getDelimiter()))
                        .collect(Collectors.toList()));
    }


    public Optional<T> findOne(Query<T> query) {
        return find(query)
                .stream()
                .findFirst();
    }

    public List<T> find(Query<T> query) {
        return findAll()
                .stream()
                .filter(query::execute)
                .collect(Collectors.toList());
    }

    public Optional<T> findById(String token) {
        return findOne(entity -> entity.getId().equals(token));
    }


    public abstract String[] serialize(T entity);

    public abstract T deserialize(String[] tokens);

    private File getDataFile() {
        return new File(String.format("%s/%s.csv", config.getDataLocation(), getGenericType().getName()));
    }

    protected Config getConfig() {
        return config;
    }
}
