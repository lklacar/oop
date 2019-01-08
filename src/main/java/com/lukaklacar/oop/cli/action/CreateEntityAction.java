package com.lukaklacar.oop.cli.action;

import com.lukaklacar.oop.data.EntityManager;
import com.lukaklacar.oop.model.AbstractModel;

public abstract class CreateEntityAction<T extends AbstractModel> extends MenuAction {

    private EntityManager<T> entityManager;

    public CreateEntityAction(String text, EntityManager<T> entityManager) {
        super(text);
        this.entityManager = entityManager;
    }


    @Override
    public void execute() {
        T entity = getEntityFromConsole();
        entityManager.save(entity);
    }

    public abstract T getEntityFromConsole();
}
