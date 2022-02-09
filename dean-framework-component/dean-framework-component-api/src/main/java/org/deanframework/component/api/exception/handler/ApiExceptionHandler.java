package org.deanframework.component.api.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.deanframework.component.api.ApiResponse;
import org.deanframework.component.api.exception.ApiException;
import org.deanframework.component.api.exception.handler.base.AbstractExceptionHandler;
import org.springframework.stereotype.Component;

/**
 * API异常处理
 * @auther Dean
 */
@Slf4j
@Component
public class ApiExceptionHandler implements AbstractExceptionHandler {

    @Override
    public ApiResponse handle(Exception e) {
        ApiException exception = (ApiException) e;
        ApiResponse response = ApiResponse.create(exception.getCode(), exception.getMessage(), exception.getData());
        log.debug("\n ###ApiExceptionHandler###{}", response);
        return response;
    }
}
