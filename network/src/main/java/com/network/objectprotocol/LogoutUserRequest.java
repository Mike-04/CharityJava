package com.network.objectprotocol;

import java.io.Serializable;

public class LogoutUserRequest implements IRequest, Serializable {
    private static final long serialVersionUID = 1L;

    private final String username;

    public LogoutUserRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}