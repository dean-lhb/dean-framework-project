package org.deanframework.component.spring;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @auther Dean
 */
public class SpringRequestContext {

    public static Map<String, String> getHeaderMap() {
        Map<String, String> headerMap = new HashMap<>();
        HttpServletRequest request = SpringContext.getRequest();
        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String header = request.getHeader(name);
            if (Objects.nonNull(header)) {
                headerMap.put(name, header);
            }
        }
        return headerMap;
    }

    public static Map<String, String> getParameterMap() {
        Map<String, String> parameterMap = new HashMap<>();
        HttpServletRequest request = SpringContext.getRequest();
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String parameter = request.getParameter(name);
            if (Objects.nonNull(parameter)) {
                parameterMap.put(name, parameter);
            }
        }
        return parameterMap;
    }

    public static String getHeader(String name) {
        return SpringContext.getRequest().getHeader(name);
    }

    public static String getParameter(String name) {
        return SpringContext.getRequest().getParameter(name);
    }

    public static Object getAttribute(String name) {
        return SpringContext.getRequest().getAttribute(name);
    }

    public static void setAttribute(String name, Object value) {
        SpringContext.getRequest().setAttribute(name, value);
    }

    public static String getIp() {
        HttpServletRequest request = SpringContext.getRequest();
        String ip;
        List<String> ipHeaders = Arrays.asList("X-Real-IP", "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR");
        for (String ipHeader : ipHeaders) {
            ip = request.getHeader(ipHeader);
            if (Objects.nonNull(ip) && !ip.isEmpty()) {
                String[] ips = ip.split(",");
                return ips[0];
            }
        }
        ip = request.getRemoteAddr();
        return ip;
    }
}
