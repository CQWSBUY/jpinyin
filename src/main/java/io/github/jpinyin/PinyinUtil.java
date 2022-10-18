package io.github.jpinyin;

/**
 * 拼音工具类
 *
 * @author Moky
 */
public class PinyinUtil {
    public static final int FULL_PINYIN_MAX_LENGTH = 50;

    /**
     * 汉字转全拼
     */
    public String getFullPinyin(String str) throws PinyinException {
        String fullPinyin = "";
        fullPinyin = PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITHOUT_TONE);
        //全拼长度超过50，则只取前50个字符
        if (fullPinyin.length() > FULL_PINYIN_MAX_LENGTH) {
            fullPinyin = fullPinyin.substring(0, FULL_PINYIN_MAX_LENGTH);
        }
        return fullPinyin;
    }

    /**
     * 汉字转简拼
     */
    public String getShortPinyin(String str) {
        return PinyinHelper.getShortPinyin(str);
    }
}
