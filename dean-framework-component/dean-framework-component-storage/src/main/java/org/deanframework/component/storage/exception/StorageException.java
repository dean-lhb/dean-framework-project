package org.deanframework.component.storage.exception;

/**
 * @auther Dean
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(Throwable cause) {
        super(cause);
    }
}
