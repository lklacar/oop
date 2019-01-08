package com.lukaklacar.oop.data;

import com.lukaklacar.oop.model.AbstractModel;

public interface Query<T extends AbstractModel> {

    boolean execute(T entity);

}
