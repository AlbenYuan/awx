package com.albenyuan.common.security;

/**
 * @Author Alben Yuan
 * @Date 2018-01-17 09:20
 */

public class MD5Util {

    public byte[] encode2Bytes(String text) {
        if (text == null) {
            return null;
        }
        return encode2Bytes(text.getBytes());
    }

    public byte[] encode2Bytes(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        return null;
    }

    public String encode(String text) {
        if (text == null) {
            return null;
        }
        return encode(text.getBytes());
    }

    public String encode(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        return null;
    }


}
