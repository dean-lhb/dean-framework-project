package org.deanframework.starter.qrcode;

import org.deanframework.component.qrcode.QRCode;
import org.deanframework.component.qrcode.config.QRCodeConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Dean
 */
@Configuration
@EnableConfigurationProperties(QRCodeProperties.class)
public class QRCodeAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(QRCode.class)
    public QRCode getQRCode(QRCodeConfig qrCodeConfig) {
        return new QRCode(qrCodeConfig);
    }
}
