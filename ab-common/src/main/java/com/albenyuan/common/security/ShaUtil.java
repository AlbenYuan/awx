package com.albenyuan.common.security;

/**
 * @Author Alben Yuan
 * @Date 2018-05-19 18:36
 */
public class ShaUtil {

    private ShaUtil() {
    }


    public static byte[] encode(byte[] bytes) {
        return MessageDigestUtil.encode(bytes, MessageDigestUtil.Algorithm.SHA);
    }

}
