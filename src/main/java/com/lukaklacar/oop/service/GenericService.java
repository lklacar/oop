package com.lukaklacar.oop.service;

import com.lukaklacar.oop.model.AbstractModel;

import java.util.List;

public interface GenericService<T extends AbstractModel> {
    T findById(String id);

    List<T> findAll();

    void save(T entity);
}
