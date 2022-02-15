package org.deanframework.starter.storage;

import org.deanframework.component.storage.config.StorageConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @auther Dean
 */
@ConfigurationProperties(prefix = "dean.storage")
public class StorageProperties extends StorageConfig {
}
