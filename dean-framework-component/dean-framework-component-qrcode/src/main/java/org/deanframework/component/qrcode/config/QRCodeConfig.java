package org.deanframework.component.qrcode.config;

/**
 * @auther Dean
 */
public class QRCodeConfig {

    //默认宽度
    private int width = 400;
    //默认高度
    private int height = 400;
    //logo默认宽度
    private final int logoWidth = width * 20 / 100;
    //logo默认高度
    private final int logoHeight = height * 20 / 100;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLogoWidth() {
        return logoWidth;
    }

    public int getLogoHeight() {
        return logoHeight;
    }
}
