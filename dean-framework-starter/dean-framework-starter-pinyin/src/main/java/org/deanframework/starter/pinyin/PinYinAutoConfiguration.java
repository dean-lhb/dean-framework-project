package org.deanframework.starter.pinyin;

import org.deanframework.component.pinyin.PinYin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Dean
 */
@Configuration
public class PinYinAutoConfiguration {

    @Bean
    public PinYin getPinYin() {
        return new PinYin();
    }
}
