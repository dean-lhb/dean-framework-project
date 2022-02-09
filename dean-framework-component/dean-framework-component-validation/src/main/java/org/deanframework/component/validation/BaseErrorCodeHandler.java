package org.deanframework.component.validation;

/**
 * @auther Dean
 */
public interface BaseErrorCodeHandler {

    default void throwError() {
        throwError(null);
    }

    default void throwError(Object data) {
        throw new ValidationException(getCode(), getMessageKey(), data);
    }

    int getCode();

    String getMessageKey();
}
