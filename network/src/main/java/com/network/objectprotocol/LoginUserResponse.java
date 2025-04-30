package com.network.objectprotocol;

import com.network.dto.UserDTO;

import java.io.Serializable;

public class LoginUserResponse implements IResponse, Serializable {
    private final UserDTO user;

    public LoginUserResponse(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }
}