package com.domain;

import java.util.UUID;

public class Entity<T>{
    T id;
    Entity(T id)
    {
        this.id = id;
    }
    public T getId() {
        return id;
    }
    public void setId(T id) {
        this.id = id;
    }
}
