package com.network.client;

import java.io.Serializable;

public class ProxyException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ProxyException() {
        super();
    }

    public ProxyException(String message) {
        super(message);
    }

    public ProxyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProxyException(Throwable cause) {
        super(cause);
    }
}