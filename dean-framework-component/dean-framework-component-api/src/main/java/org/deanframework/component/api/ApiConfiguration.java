package org.deanframework.component.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Dean
 */
@Configuration
public class ApiConfiguration {

    @ConfigurationProperties(ApiConstant.CONFIG_PREFIX)
    @Bean
    public ApiProperties apiProperties() {
        return new ApiProperties();
    }
}
