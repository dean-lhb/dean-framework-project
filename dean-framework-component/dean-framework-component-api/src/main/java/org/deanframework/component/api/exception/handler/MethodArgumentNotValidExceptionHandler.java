package org.deanframework.component.api.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.deanframework.component.api.ApiCode;
import org.deanframework.component.api.ApiResponse;
import org.deanframework.component.api.exception.handler.base.AbstractExceptionHandler;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * 参数校验异常
 * @auther Dean
 */
@Slf4j
@Component
public class MethodArgumentNotValidExceptionHandler implements AbstractExceptionHandler {

    @Override
    public ApiResponse handle(Exception e) {
        FieldError fieldError = ((MethodArgumentNotValidException) e).getBindingResult().getFieldError();
        ApiResponse response = ApiResponse.create(ApiCode.INVALID_PARAMETER.getCode(), "[" + fieldError.getField() + "]" + fieldError.getDefaultMessage());
        log.debug("\n ###MethodArgumentNotValidException###{}", response);
        return response;
    }
}
