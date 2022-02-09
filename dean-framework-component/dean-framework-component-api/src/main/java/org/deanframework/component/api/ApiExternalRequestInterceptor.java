package org.deanframework.component.api;

import lombok.extern.slf4j.Slf4j;
import org.deanframework.component.api.hook.ApiExternalRequestHook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * API外部请求拦截器
 * @auther Dean
 */
@Slf4j
@Component
public class ApiExternalRequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired(required = false)
    private ApiExternalRequestHook hook;

    @Autowired
    private ApiProperties properties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("\n ###API外部请求RequestURL###{}", request.getRequestURL());
        String path = request.getRequestURI();
        if (Objects.nonNull(hook)) {
            hook.preHandle(request, response, handler);
        }
        request.setAttribute(ApiConstant.EXTERNAL_FORWARD, true);
        request.getRequestDispatcher(path.replaceFirst(properties.getRoute().getExternalPrefix(), properties.getRoute().getInternalPrefix())).forward(request, response);
        return false;
    }
}
