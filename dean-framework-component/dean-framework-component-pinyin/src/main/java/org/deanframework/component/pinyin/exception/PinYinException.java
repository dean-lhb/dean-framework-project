package org.deanframework.component.pinyin.exception;

/**
 * @auther Dean
 */
public class PinYinException extends RuntimeException {

    public PinYinException(String message) {
        super(message);
    }

    public PinYinException(Throwable cause) {
        super(cause);
    }
}
