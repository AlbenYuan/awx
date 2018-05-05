package com.albenyuan.common.util;

/**
 * @Author Alben Yuan
 * @Date 2017-12-19 14:18
 */
public class EmoticonUtil {

//    public static final String EMOTICON_PATTERN = "[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]|[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]|[\\u2600-\\u27ff]";


    private EmoticonUtil() {
    }
    

    /**
     * 是否包含表情
     *
     * @param source 源字符串
     * @return
     */
    public boolean hasEmoticon(String source) {
        if (null != source) {
            for (Character character : source.toCharArray()) {
                if (isEmoticon(character)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isEmoticon(int code) {
        return (code >= 0x2600 && code <= 0x27BF) // 杂项符号与符号字体
                || code == 0x303D
                || code == 0x2049
                || code == 0x203C
                || (code >= 0x2000 && code <= 0x200F)//
                || (code >= 0x2028 && code <= 0x202F)//
                || code == 0x205F //
                || (code >= 0x2065 && code <= 0x206F)//
                /* 标点符号占用区域 */
                || (code >= 0x2100 && code <= 0x214F)// 字母符号
                || (code >= 0x2300 && code <= 0x23FF)// 各种技术符号
                || (code >= 0x2B00 && code <= 0x2BFF)// 箭头A
                || (code >= 0x2900 && code <= 0x297F)// 箭头B
                || (code >= 0x3200 && code <= 0x32FF)// 中文符号
                || (code >= 0xD800 && code <= 0xDFFF)// 高低位替代符保留区域
                || (code >= 0xE000 && code <= 0xF8FF)// 私有保留区域
                || (code >= 0xFE00 && code <= 0xFE0F)// 变异选择器
                || code >= 0x10000; // Plane在第二平面以上的，char都不可以存，全部都转
    }

    public static boolean isNotEmoticon(int code) {
        return !isEmoticon(code);
    }

    public static String replace(String source) {
        return replace(source, "");
    }

    public static String toUnicode(String source) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            int code = source.codePointAt(i);
            if (isEmoticon(code)) {
                unicode.append("\\u").append(Integer.toHexString(c));
            } else {
                unicode.append(c);
            }
        }
        return unicode.toString();
    }

    public static String unicode2Emoticon(String source) {
        if (null == source) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        int maxLoop = source.length();
        for (int i = 0; i < maxLoop; i++) {
            if (source.charAt(i) == '\\') {
                if ((i < maxLoop - 5) && ((source.charAt(i + 1) == 'u') || (source.charAt(i + 1) == 'U'))) {
                    try {
                        buffer.append((char) Integer.parseInt(source.substring(i + 2, i + 6), 16));
                        i += 5;
                    } catch (NumberFormatException localNumberFormatException) {
                        buffer.append(source.charAt(i));
                    }
                } else {
                    buffer.append(source.charAt(i));
                }
            } else {
                buffer.append(source.charAt(i));
            }
        }
        return buffer.toString();
    }

    public static String replace(String source, String newChar) {
        newChar = null == newChar ? "" : newChar;
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            int code = source.codePointAt(i);
            unicode.append(isEmoticon(code) ? newChar : c);
        }
        return unicode.toString();
    }

}
