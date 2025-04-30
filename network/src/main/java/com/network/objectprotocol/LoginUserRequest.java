package com.network.objectprotocol;

import java.io.Serializable;

public class LoginUserRequest implements IRequest, Serializable {
    private final String username;
    private final String password;

    public LoginUserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}