package org.deanframework.component.qrcode.exception;

/**
 * @auther Dean
 */
public class QRCodeException extends RuntimeException {

    public QRCodeException(String message) {
        super(message);
    }

    public QRCodeException(Throwable cause) {
        super(cause);
    }
}
