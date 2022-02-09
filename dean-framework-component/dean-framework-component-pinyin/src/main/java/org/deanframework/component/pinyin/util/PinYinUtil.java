package org.deanframework.component.pinyin.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import org.deanframework.component.pinyin.constant.PinYinConstant;
import org.deanframework.component.pinyin.exception.PinYinException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther Dean
 */
public class PinYinUtil {

    public static String parsePinyin(String string) {
        if (string != null && string.length() > 0) {
            String character = String.valueOf(string.charAt(0));
            //判断是英文
            if (match(character, PinYinConstant.MATCH_ENGLISH)) {
                return character.toUpperCase();
            }
            //判断是中文
            if (match(character, PinYinConstant.MATCH_CHINESE)) {
                return String.valueOf(parseSingleHanziToPinyin(string.charAt(0)).charAt(0)).toUpperCase();
            }
        }
        return PinYinConstant.EMPTY;
    }

    private static String parseSingleHanziToPinyin(char hanzi) {
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String[] result = PinyinHelper.toHanyuPinyinStringArray(hanzi, outputFormat);
            //多音字，则取第一个拼音
            stringBuffer.append(result[0]);
        } catch (Exception e) {
            throw new PinYinException(e);
        }
        return stringBuffer.toString();
    }

    private static boolean match(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
