package org.bsuir.exception;

public class CustomClientException extends Exception {

    public CustomClientException() {
    }

    public CustomClientException(String message) {
        super(message);
    }

    public CustomClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomClientException(Throwable cause) {
        super(cause);
    }
}
