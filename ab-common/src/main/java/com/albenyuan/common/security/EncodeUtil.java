package com.albenyuan.common.security;

import java.io.UnsupportedEncodingException;

/**
 * @Author Alben Yuan
 * @Date 2018-01-17 22:49
 */

public class EncodeUtil {

    public static final String CHARSET_UTF8 = "utf-8";
    public static final String CHARSET_GB2312 = "gb2312";
    public static final String CHARSET_ISO88591 = "iso8859-1";
    public static final String CHARSET_GBK = "gbk";
    public static final String CHARSET_DEFAULT = CHARSET_UTF8;

    /**
     * 将二进制转换成16进制
     *
     * @param bytes
     * @return
     */
    public static String parseByte2Hex(byte[] bytes) {
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
    public static byte[] parseHex2Bytes(String hex) {
        if (hex.length() < 1) {
            return null;
        }
        byte[] result = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length() / 2; i++) {
            int high = Integer.parseInt(hex.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hex.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }


    public String convert(String text, String sourceCharset, String targetCharset) throws UnsupportedEncodingException {
        byte[] bytes = text.getBytes(sourceCharset); //解码
        return convert(bytes, targetCharset);
    }

    public String convert(byte[] bytes, String charset) throws UnsupportedEncodingException {
        return new String(bytes, charset);
    }
}
