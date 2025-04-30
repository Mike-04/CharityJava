package com.network.client;

import java.io.Serializable;

public class ServerProcessingException extends RuntimeException implements Serializable {
  private Exception exception;

  public ServerProcessingException() {
    super();
  }

  public ServerProcessingException(Exception exception) {
    super(exception);
    this.exception = exception;
  }

  public ServerProcessingException(String message) {
    super(message);
  }

  public ServerProcessingException(String message, Throwable cause) {
    super(message, cause);
  }
}