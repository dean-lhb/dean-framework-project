package org.deanframework.component.api.hook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * API请求钩子
 * @auther Dean
 */
public interface ApiRequestHook {

    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler);
}
