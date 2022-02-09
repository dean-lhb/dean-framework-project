package org.deanframework.component.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * API拦截配置
 * @auther Dean
 */
@Configuration
public class ApiInterceptorConfigurer implements WebMvcConfigurer {

    @Autowired
    private ApiExternalRequestInterceptor externalRequestInterceptor;

    @Autowired
    private ApiInternalRequestInterceptor internalRequestInterceptor;

    @Autowired
    private ApiProperties properties;

    /**
     * 添加拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(externalRequestInterceptor)
                .addPathPatterns("/" + properties.getRoute().getExternalPrefix() + "/**");
        registry.addInterceptor(internalRequestInterceptor)
                .addPathPatterns("/" + properties.getRoute().getInternalPrefix() + "/**");
    }
}
