package org.deanframework.component.api.exception.handler.base;

import org.deanframework.component.api.ApiResponse;

/**
 * @auther Dean
 */
public interface AbstractExceptionHandler {

    ApiResponse handle(Exception e);
}
