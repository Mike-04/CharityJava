package com.repository;

import com.domain.User;

import java.util.UUID;

public interface UserIRepository extends IRepository<UUID, User> {
    public User findByUsername(String username);
}
