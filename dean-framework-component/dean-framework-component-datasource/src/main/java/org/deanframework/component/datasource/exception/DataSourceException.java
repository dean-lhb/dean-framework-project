package org.deanframework.component.datasource.exception;

/**
 * @auther Dean
 */
public class DataSourceException extends RuntimeException {

    public DataSourceException(String message) {
        super(message);
    }

    public DataSourceException(Throwable cause) {
        super(cause);
    }
}
