package com.albenyuan.common.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

import com.albenyuan.common.io.Charsets;

/**
 * @Author Alben Yuan
 * @Date 2018-01-17 09:20
 */

public class MD5Util {

    private static final Logger logger = LoggerFactory.getLogger(MD5Util.class);


    private MD5Util() {
    }

    public static byte[] encode2Bytes(byte[] bytes) {
        return MessageDigestUtil.encode(bytes, MessageDigestUtil.Algorithm.MD5);
    }

    public static byte[] encode2Bytes(String text, String charset) {
        return encode2Bytes(text, Charset.forName(charset.toUpperCase()));
    }

    public static byte[] encode2Bytes(String text, Charset charset) {
        return null == text ? null : encode2Bytes(text.getBytes(charset));
    }

    public static byte[] encode2Bytes(String text) {
        return encode2Bytes(text, Charsets.DEFAULT_CHARSET);
    }

    public static String encode(String text, Charset charset) {
        return null == text ? null : encode(text.getBytes(charset));
    }

    public static String encode(String text, String charset) {
        return encode(text, Charset.forName(charset.toUpperCase()));
    }

    public static String encode(String text) {
        return encode(text, Charsets.DEFAULT_CHARSET);
    }

    public static String encode(byte[] bytes) {
        return EncodeUtil.parseByte2Hex(encode2Bytes(bytes));
    }

}
