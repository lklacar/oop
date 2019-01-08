package com.lukaklacar.oop.service;

import com.lukaklacar.oop.data.EntityManager;
import com.lukaklacar.oop.exceptions.EntityNotFound;
import com.lukaklacar.oop.model.AbstractModel;

import javax.inject.Inject;
import java.util.List;

public class GenericServiceImpl<T extends AbstractModel> implements GenericService<T> {

    private EntityManager<T> entityManager;

    @Inject
    public GenericServiceImpl(EntityManager<T> entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T findById(String id) {
        return entityManager.findById(id).orElseThrow(EntityNotFound::new);
    }

    @Override
    public List<T> findAll() {
        return entityManager.findAll();
    }

    @Override
    public void save(T entity) {
        entityManager.save(entity);
    }
}
