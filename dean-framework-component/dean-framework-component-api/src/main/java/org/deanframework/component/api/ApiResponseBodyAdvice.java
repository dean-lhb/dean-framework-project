package org.deanframework.component.api;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * API响应通知
 * @auther Dean
 */
@Slf4j
@ControllerAdvice
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private ApiProperties properties;

    public ApiResponseBodyAdvice(ApiProperties properties) {
        this.properties = properties;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return ApiAdvice.supports(methodParameter.getMethod(), properties.getResponseBodyAdviceNotIncludePackages());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest request, ServerHttpResponse response) {
        log.debug("\n ###API响应body###{}", JSON.toJSONString(body));
        if (body instanceof ApiResponse) {
            return body;
        }
        ApiResponse bodyResponse = ApiResponse.create(ApiCode.SUCCESS.getCode(), ApiCode.SUCCESS.getMessage(), body);
        if (body instanceof String) {
            return JSON.toJSONString(bodyResponse);
        }
        return bodyResponse;
    }
}
