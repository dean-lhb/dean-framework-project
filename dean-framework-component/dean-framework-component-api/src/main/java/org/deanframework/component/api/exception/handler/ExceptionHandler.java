package org.deanframework.component.api.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.deanframework.component.api.exception.handler.base.ExceptionHandlerFactory;
import org.deanframework.component.api.ApiResponse;
import org.deanframework.component.api.exception.handler.base.AbstractExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * 异常处理
 * @auther Dean
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandler implements AbstractExceptionHandler {

    @Autowired
    private ExceptionHandlerFactory exceptionHandlerFactory;

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @Override
    public ApiResponse handle(Exception e) {
        log.error("\n ###API异常处理###" + e.getClass().getName(), e);
        AbstractExceptionHandler handler = exceptionHandlerFactory.getHandler(e.getClass().getSimpleName());
        if (Objects.isNull(handler)) {
            handler = exceptionHandlerFactory.getHandler(Exception.class.getSimpleName());
        }
        return handler.handle(e);
    }
}
