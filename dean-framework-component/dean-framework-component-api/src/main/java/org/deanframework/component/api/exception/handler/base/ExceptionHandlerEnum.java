package org.deanframework.component.api.exception.handler.base;

import lombok.Getter;

/**
 * @auther Dean
 */
public enum ExceptionHandlerEnum {

    Exception("defaultExceptionHandler"),
    ApiException("apiExceptionHandler"),
    ValidationException("validationExceptionHandler"),
    ConstraintViolationException("constraintViolationExceptionHandler"),
    MethodArgumentNotValidException("methodArgumentNotValidExceptionHandler"),
    ;

    @Getter
    private String className;
    @Getter
    private String beanName;

    ExceptionHandlerEnum(String beanName) {
        this.className = this.name();
        this.beanName = beanName;
    }

    public static ExceptionHandlerEnum getExceptionHandlerEnum(String className) {
        for (ExceptionHandlerEnum handlerEnum : values()) {
            if (handlerEnum.getClassName().equals(className)) {
                return handlerEnum;
            }
        }
        return null;
    }
}
