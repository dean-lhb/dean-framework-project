package org.deanframework.component.storage.util;

import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @auther Dean
 */
public class StorageUtil {

    public static String getDir(String format) {
        SimpleDateFormat date = new SimpleDateFormat(format);
        return date.format(System.currentTimeMillis());
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
