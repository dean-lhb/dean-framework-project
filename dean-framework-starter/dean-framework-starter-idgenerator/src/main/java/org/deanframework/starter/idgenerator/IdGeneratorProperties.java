package org.deanframework.starter.idgenerator;

import org.deanframework.component.idgenerator.config.IdGeneratorConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @auther Dean
 */
@ConfigurationProperties(prefix = "dean.id-generator")
public class IdGeneratorProperties extends IdGeneratorConfig {
}
