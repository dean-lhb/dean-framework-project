package org.deanframework.component.pinyin;

import org.deanframework.component.pinyin.util.PinYinUtil;

/**
 * @auther Dean
 */
public class PinYin {

    public String parsePinyin(String string) {
        return PinYinUtil.parsePinyin(string);
    }
}
