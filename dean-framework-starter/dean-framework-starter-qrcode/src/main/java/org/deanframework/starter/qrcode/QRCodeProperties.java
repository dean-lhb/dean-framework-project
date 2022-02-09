package org.deanframework.starter.qrcode;

import org.deanframework.component.qrcode.config.QRCodeConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @auther Dean
 */
@ConfigurationProperties(prefix = "dean.qrcode")
public class QRCodeProperties extends QRCodeConfig {
}
