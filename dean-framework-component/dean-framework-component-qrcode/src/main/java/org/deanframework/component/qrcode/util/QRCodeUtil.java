package org.deanframework.component.qrcode.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.deanframework.component.qrcode.constant.QRCodeConstant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

/**
 * @auther Dean
 */
public class QRCodeUtil {

    /**
     * 生成二维码
     * @param content    内容
     * @param width      二维码宽度
     * @param height     二维码高度
     * @param logoUrl    logo资源
     * @param logoWidth  logo 宽度
     * @param logoHeight logo 高度
     * @return
     */
    public static BufferedImage createQRCode(String content, int width, int height, String logoUrl, int logoWidth, int logoHeight) throws Exception {
        HashMap<EncodeHintType, Comparable> hints = new HashMap<>(4);
        //指定字符编码为utf-8
        hints.put(EncodeHintType.CHARACTER_SET, QRCodeConstant.CHARSET);
        //指定二维码的纠错等级为中级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //设置图片的边距
        hints.put(EncodeHintType.MARGIN, 1);
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        if (Objects.nonNull(logoUrl)) {
            insertLogo(bufferedImage, width, height, logoUrl, logoWidth, logoHeight);
        }
        return bufferedImage;
    }

    /**
     * 二维码插入logo
     * @param source     二维码
     * @param width      二维码宽度
     * @param height     二维码高度
     * @param logoUrl    logo资源
     * @param logoWidth  logo 宽度
     * @param logoHeight logo 高度
     * @throws IOException
     */
    private static void insertLogo(BufferedImage source, int width, int height, String logoUrl, int logoWidth, int logoHeight) throws IOException {
        BufferedImage src;
        if (logoUrl.startsWith(QRCodeConstant.HTTP_PROTOCO)) {
            src = ImageIO.read(new URL(logoUrl));
        } else {
            src = ImageIO.read(new File(logoUrl));
        }
        int srcSize;
        int srcX = 0;
        int srcY = 0;
        if (src.getWidth() < src.getHeight()) {
            srcSize = src.getWidth();
            srcY = (src.getHeight() - srcSize) / 2;
        } else {
            srcSize = src.getHeight();
            srcX = (src.getWidth() - srcSize) / 2;
        }
        src = src.getSubimage(srcX, srcY, srcSize, srcSize);
        //插入logo
        Graphics2D graph = source.createGraphics();
        int x = (width - logoWidth) / 2;
        int y = (height - logoHeight) / 2;
        graph.drawImage(src.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH), x, y, logoWidth, logoHeight, null);
        Shape shape = new RoundRectangle2D.Float(x, y, logoWidth, logoHeight, 15, 15);
        graph.setStroke(new BasicStroke(5f));
        graph.draw(shape);
        graph.dispose();
    }
}
