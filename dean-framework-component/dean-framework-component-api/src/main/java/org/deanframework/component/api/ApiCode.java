package org.deanframework.component.api;

/**
 * @auther Dean
 */
public enum ApiCode {

    SUCCESS(200, "success"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    INVALID_TOKEN(4000, "invalid token"),
    INVALID_PARAMETER(4001, "invalid parameter"),
    ;

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ApiCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
