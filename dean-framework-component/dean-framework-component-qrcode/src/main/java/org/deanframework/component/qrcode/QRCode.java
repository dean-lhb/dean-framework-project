package org.deanframework.component.qrcode;

import org.deanframework.component.qrcode.constant.QRCodeConstant;
import org.deanframework.component.qrcode.exception.QRCodeException;
import org.deanframework.component.qrcode.config.QRCodeConfig;
import org.deanframework.component.qrcode.util.QRCodeUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @auther Dean
 */
public class QRCode {

    private QRCodeConfig qrCodeConfig;

    public QRCode(QRCodeConfig qrCodeConfig) {
        this.qrCodeConfig = qrCodeConfig;
    }

    /**
     * 生成二维码
     * @param content
     * @param fileName
     */
    public void makeQRCode(String content, String fileName) {
        makeQRCode(content, fileName, null);
    }

    /**
     * 生成带logo二维码
     * @param content
     * @param fileName
     * @param logoUrl
     */
    public void makeQRCode(String content, String fileName, String logoUrl) {
        try (OutputStream output = new FileOutputStream(fileName)) {
            BufferedImage image = QRCodeUtil.createQRCode(content, qrCodeConfig.getWidth(), qrCodeConfig.getHeight(), logoUrl, qrCodeConfig.getLogoWidth(), qrCodeConfig.getLogoHeight());
            ImageIO.write(image, QRCodeConstant.IMAGE_FORMAT, output);
        } catch (Exception e) {
            throw new QRCodeException(e);
        }
    }
}
