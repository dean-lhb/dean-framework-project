package org.deanframework.component.storage.exception;

/**
 * @auther Dean
 */
public class StorageNotAllowException extends RuntimeException {

    public StorageNotAllowException(String message) {
        super(message);
    }

    public StorageNotAllowException(Throwable cause) {
        super(cause);
    }
}
