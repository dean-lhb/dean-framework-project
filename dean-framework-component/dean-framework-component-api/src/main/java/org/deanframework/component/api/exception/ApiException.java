package org.deanframework.component.api.exception;

/**
 * @auther Dean
 */
public class ApiException extends RuntimeException {

    private int code;
    private String message;
    private Object data;

    public ApiException(int code, String message) {
        this(code, message, null);
    }

    public ApiException(int code, String message, Object data) {
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
