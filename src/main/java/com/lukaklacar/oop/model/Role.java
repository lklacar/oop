package com.lukaklacar.oop.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends AbstractModel {

    private String name;

    @Builder
    public Role(String id, String id1, String name) {
        super(id);
        this.name = name;
    }

}