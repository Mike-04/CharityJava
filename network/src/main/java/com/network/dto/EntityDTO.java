package com.network.dto;

import java.io.Serializable;

public class EntityDTO<T> implements Serializable {
    private T id;

    public EntityDTO(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}