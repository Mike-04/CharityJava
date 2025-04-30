package com.repo;

import com.domain.User;
import com.repo.IRepository;

import java.util.UUID;

public interface UserIRepository extends IRepository<UUID, User> {
    public User findByUsername(String username);
}
