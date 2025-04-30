package com.domain;

import java.util.UUID;

public class User extends Entity<UUID> {
    String username;
    String passwordhash;

    public User(String username, String passwordhash)
    {
        super(UUID.randomUUID());
        this.username = username;
        this.passwordhash = passwordhash;
    }

    public User(UUID id, String username, String passwordhash)
    {
        super(id);
        this.username = username;
        this.passwordhash = passwordhash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", username='" + username + '\'' +
                ", passwordhash='" + passwordhash + '\'' +
                '}';
    }
}
