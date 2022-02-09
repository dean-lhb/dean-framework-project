package org.deanframework.component.api.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.deanframework.component.api.ApiResponse;
import org.deanframework.component.api.ApiCode;
import org.deanframework.component.api.exception.handler.base.AbstractExceptionHandler;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * 参数校验异常
 * @auther Dean
 */
@Slf4j
@Component
public class ConstraintViolationExceptionHandler implements AbstractExceptionHandler {

    @Override
    public ApiResponse handle(Exception e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = ((ConstraintViolationException) e).getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            String[] propertyName = violation.getPropertyPath().toString().split("\\.");
            message.append("[").append(propertyName[1]).append("]");
            message.append(violation.getMessage());
            message.append(",");
        }
        ApiResponse response = ApiResponse.create(ApiCode.INVALID_PARAMETER.getCode(), message.toString().substring(0, message.toString().length() - 1));
        log.debug("\n ###ConstraintViolationException###{}", response);
        return response;
    }
}
