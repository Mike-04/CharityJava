package com.repo;

import com.domain.Entity;

public interface IRepository<Id, T extends Entity<Id>> {
    void add(T entity);
    void remove(Id id);
    void update(T entity);
    T find(Id id);
    Iterable<T> getAll();
}