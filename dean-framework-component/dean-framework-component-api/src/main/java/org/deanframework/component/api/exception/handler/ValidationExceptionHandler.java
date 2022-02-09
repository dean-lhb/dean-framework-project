package org.deanframework.component.api.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.deanframework.component.api.ApiResponse;
import org.deanframework.component.api.exception.handler.base.AbstractExceptionHandler;
import org.deanframework.component.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * 验证异常处理
 * @auther Dean
 */
@Slf4j
@Component
public class ValidationExceptionHandler implements AbstractExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    public ApiResponse handle(Exception e) {
        ValidationException exception = (ValidationException) e;
        String message = messageSource.getMessage(exception.getMessage(), null, null);
        ApiResponse response = ApiResponse.create(exception.getCode(), message, exception.getData());
        log.debug("\n ###ValidationExceptionHandler###{}", response);
        return response;
    }
}
