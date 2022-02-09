package org.deanframework.component.api.exception.handler.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @auther Dean
 */
@Component
public class ExceptionHandlerFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public AbstractExceptionHandler getHandler(String className) {
        ExceptionHandlerEnum handlerEnum = ExceptionHandlerEnum.getExceptionHandlerEnum(className);
        if (Objects.isNull(handlerEnum)) {
            return null;
        }
        return applicationContext.getBean(handlerEnum.getBeanName(), AbstractExceptionHandler.class);
    }
}
