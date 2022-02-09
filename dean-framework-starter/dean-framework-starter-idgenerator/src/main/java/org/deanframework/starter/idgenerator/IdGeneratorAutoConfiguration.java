package org.deanframework.starter.idgenerator;

import org.deanframework.component.idgenerator.IdGenerator;
import org.deanframework.component.idgenerator.config.IdGeneratorConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Dean
 */
@Configuration
@EnableConfigurationProperties(IdGeneratorProperties.class)
public class IdGeneratorAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(IdGenerator.class)
    public IdGenerator getIdGenerator(IdGeneratorConfig idGeneratorConfig) {
        return new IdGenerator(idGeneratorConfig);
    }
}
