package org.deanframework.starter.storage;

import org.deanframework.component.storage.config.StorageConfig;
import org.deanframework.component.storage.service.UploadService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Dean
 */
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class StorageAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(UploadService.class)
    public UploadService getUploadService(StorageConfig storageConfig) {
        return new UploadService(storageConfig);
    }
}
