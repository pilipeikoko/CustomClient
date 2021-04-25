package org.bsuir.exception;

public class EmptyFieldException extends Throwable {
    private final String message;

    public EmptyFieldException() {
        this.message = "Empty field";
    }

    public EmptyFieldException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
