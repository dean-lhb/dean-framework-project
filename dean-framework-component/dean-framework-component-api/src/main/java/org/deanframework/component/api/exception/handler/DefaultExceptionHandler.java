package org.deanframework.component.api.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.deanframework.component.api.ApiCode;
import org.deanframework.component.api.ApiResponse;
import org.deanframework.component.api.exception.handler.base.AbstractExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * 默认异常处理
 * @auther Dean
 */
@Slf4j
@Component
public class DefaultExceptionHandler implements AbstractExceptionHandler {

    @Autowired
    private HttpServletResponse httpResponse;

    @Override
    public ApiResponse handle(Exception e) {
        httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        ApiResponse response = ApiResponse.create(ApiCode.INTERNAL_SERVER_ERROR.getCode(), ApiCode.INTERNAL_SERVER_ERROR.getMessage());
        log.debug("\n ###API默认异常处理###{}", response);
        return response;
    }
}
