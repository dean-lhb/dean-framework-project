package org.deanframework.common.util;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @auther Dean
 */
public class DataConvertUtil {

    public static <T> T parseObject(Object data, Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(data), clazz);
    }

    public static <T> T parseObject(String data, Class<T> clazz) {
        return JSON.parseObject(data, clazz);
    }

    public static <T> List<T> parseArray(Object data, Class<T> clazz) {
        return JSON.parseArray(JSON.toJSONString(data), clazz);
    }

    public static <T> List<T> parseArray(String data, Class<T> clazz) {
        return JSON.parseArray(data, clazz);
    }
}
