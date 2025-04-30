package com.network.dto;

import com.domain.User;

import java.io.Serializable;
import java.util.UUID;

public class UserDTO extends EntityDTO<UUID> implements Serializable {
    private String username;
    private String passwordHash;

    public UserDTO(UUID id, String username, String passwordHash) {
        super(id);
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getPasswordHash());
    }

    public User toUser() {
        return new User(getId(), username, passwordHash);
    }
}