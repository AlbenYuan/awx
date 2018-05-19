package com.albenyuan.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * @Author Alben Yuan
 * @Date 2018-01-17 22:49
 */

public class EncodeUtil {

    private static final Logger logger = LoggerFactory.getLogger(EncodeUtil.class);

    public static final String CHARSET_UTF8 = "utf-8";
    public static final String CHARSET_GB2312 = "gb2312";
    public static final String CHARSET_ISO88591 = "iso8859-1";
    public static final String CHARSET_GBK = "gbk";
//    public static final String CHARSET_DEFAULT = CHARSET_UTF8;

    /**
     * 将二进制转换成16进制大写展示
     *
     * @param bytes
     * @return
     */
    public static String parseByte2Hex(byte[] bytes) {
        if (null == bytes) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hex
     * @return
     */
    public static byte[] parseHex2Byte(String hex) {
        if (null == hex) {
            return null;
        }
        int length = hex.length() / 2;
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            int index = i << 1;
            int high = Integer.parseInt(hex.substring(index, index + 1), 16);
            int low = Integer.parseInt(hex.substring(index + 1, index + 2), 16);
            result[i] = (byte) ((high << 4) + low);
        }
        return result;
    }

    /**
     * 字符串转码
     *
     * @param text          源字符串
     * @param sourceCharset 源字符串编码
     * @param targetCharset 目标编码
     * @return
     */
    public static String convert(String text, String sourceCharset, String targetCharset) {
        return convert(text, Charset.forName(sourceCharset), Charset.forName(targetCharset));
    }

    /**
     * 字符串转码
     *
     * @param text
     * @param sourceCharset
     * @param targetCharset
     * @return
     */
    public static String convert(String text, Charset sourceCharset, Charset targetCharset) {
        return null == text ? null : convert(text.getBytes(sourceCharset), targetCharset);
    }

    /**
     * 将字byte转成目标编码字符串
     *
     * @param bytes
     * @param charset
     * @return
     */
    public static String convert(byte[] bytes, Charset charset) {
        return null == bytes ? null : new String(bytes, charset);
    }
    
}
