package org.deanframework.component.storage.exception;

/**
 * @auther Dean
 */
public class StorageMaxLimitException extends RuntimeException {

    public StorageMaxLimitException(String message) {
        super(message);
    }

    public StorageMaxLimitException(Throwable cause) {
        super(cause);
    }
}
