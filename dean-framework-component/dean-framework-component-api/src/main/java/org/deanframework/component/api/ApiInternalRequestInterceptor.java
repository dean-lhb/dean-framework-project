package org.deanframework.component.api;

import lombok.extern.slf4j.Slf4j;
import org.deanframework.component.api.hook.ApiInternalRequestHook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * API内部请求拦截器
 * @auther Dean
 */
@Slf4j
@Component
public class ApiInternalRequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired(required = false)
    private ApiInternalRequestHook hook;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("\n ###API内部请求RequestURL###{}", request.getRequestURL());
        if (Objects.nonNull(hook)) {
            hook.preHandle(request, response, handler);
        }
        return super.preHandle(request, response, handler);
    }
}
