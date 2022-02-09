package org.deanframework.component.api;

import java.lang.reflect.Method;

/**
 * @auther Dean
 */
public class ApiAdvice {

    public static boolean supports(Method method, String[] packageNames) {
        String className = method.getDeclaringClass().getName();
        for (String packageName : packageNames) {
            if (className.startsWith(packageName)) {
                return false;
            }
        }
        return true;
    }
}
