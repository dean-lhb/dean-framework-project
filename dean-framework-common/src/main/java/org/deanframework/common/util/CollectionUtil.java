package org.deanframework.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Dean
 */
public class CollectionUtil {

    /**
     * 集合合并
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    public static <T> List<T> merge(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<>(list1);
        list.addAll(list2);
        return list;
    }
}
