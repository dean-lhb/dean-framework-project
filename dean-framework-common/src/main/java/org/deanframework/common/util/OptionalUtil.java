package org.deanframework.common.util;

import java.math.BigDecimal;

/**
 * @auther Dean
 */
public class OptionalUtil {

    /**
     * 如果value非空返回value，否则返回defaultValue
     * @param value
     * @param defaultValue
     * @return
     */
    public static BigDecimal ofNullable(BigDecimal value, BigDecimal defaultValue) {
        return value == null ? defaultValue : value;
    }

    /**
     * 如果value非空返回value，否则返回0
     * @param value
     * @return
     */
    public static BigDecimal ofNullable(BigDecimal value) {
        return ofNullable(value, BigDecimal.ZERO);
    }

    /**
     * 如果value非空返回value，否则返回defaultValue
     * @param value
     * @param defaultValue
     * @return
     */
    public static Integer ofNullable(Integer value, Integer defaultValue) {
        return value == null ? defaultValue : value;
    }

    /**
     * 如果value非空返回value，否则返回0
     * @param value
     * @return
     */
    public static Integer ofNullable(Integer value) {
        return ofNullable(value, 0);
    }

    /**
     * 如果value非空返回value，否则返回defaultValue
     * @param value
     * @param defaultValue
     * @return
     */
    public static Long ofNullable(Long value, Long defaultValue) {
        return value == null ? defaultValue : value;
    }

    /**
     * 如果value非空返回value，否则返回0
     * @param value
     * @return
     */
    public static Long ofNullable(Long value) {
        return ofNullable(value, 0L);
    }

    /**
     * 如果value非空返回value，否则返回defaultValue
     * @param value
     * @param defaultValue
     * @return
     */
    public static String ofNullable(String value, String defaultValue) {
        return value == null ? defaultValue : value;
    }

    /**
     * 如果value非空返回value，否则返回空字符串
     * @param value
     * @return
     */
    public static String ofNullable(String value) {
        return ofNullable(value, "");
    }
}
