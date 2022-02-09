package org.deanframework.component.validation;

/**
 * @auther Dean
 */
public class ValidationException extends RuntimeException {

    private int code;
    private String message;
    private Object data;

    public ValidationException(int code, String message) {
        this(code, message, null);
    }

    public ValidationException(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
