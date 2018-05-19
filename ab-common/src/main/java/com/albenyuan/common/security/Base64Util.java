package com.albenyuan.common.security;

import com.albenyuan.common.io.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Author Alben Yuan
 * @Date 2017-12-25 13:20
 */

public class Base64Util {

    private Base64Util() {
    }


    /**
     * 编码字符串
     *
     * @param bytes
     * @return
     */
    public static String encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }


    /**
     * 编码字符串
     *
     * @param source
     * @return
     */
    public static String encode(String source, String charset) {
        return encode(source, Charset.forName(charset));
    }

    /**
     * 编码字符串
     *
     * @param plaintext
     * @return
     */
    public static String encode(String plaintext) {
        return encode(plaintext, Charsets.DEFAULT_CHARSET);
    }


    /**
     * 编码字符串
     *
     * @param plaintext
     * @return
     */
    public static String encode(String plaintext, Charset charset) {
        return encode(plaintext.getBytes(charset));
    }


    /**
     * 编码字符串
     *
     * @param bytes
     * @return
     */
    public static byte[] encode2Byte(byte[] bytes) {
        return Base64.encodeBase64(bytes);
    }


    /**
     * 编码字符串
     *
     * @param source
     * @return
     */
    public static byte[] encode2Byte(String source, String charset) {
        return encode2Byte(source, Charset.forName(charset));
    }

    /**
     * 编码字符串
     *
     * @param plaintext
     * @return
     */
    public static byte[] encode2Byte(String plaintext) {
        return encode2Byte(plaintext, Charsets.DEFAULT_CHARSET);
    }


    /**
     * 编码字符串
     *
     * @param plaintext
     * @return
     */
    public static byte[] encode2Byte(String plaintext, Charset charset) {
        return encode2Byte(plaintext.getBytes(charset));
    }


    /**
     * 编码文件
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static byte[] encode2Byte(File file) throws IOException {
        byte[] bytes = FileUtils.readFileToByteArray(file);
        return encode2Byte(bytes);
    }

    /**
     * 解码字符串
     *
     * @param bytes
     * @return
     */
    public static byte[] decode2Byte(byte[] bytes) {
        return Base64.decodeBase64(bytes);
    }


    /**
     * 解码字符串
     *
     * @param ciphertext
     * @return
     */
    public static byte[] decode2Byte(String ciphertext, Charset charset) {
        return decode2Byte(ciphertext.getBytes(charset));
    }

    /**
     * 解码字符串
     *
     * @param ciphertext
     * @return
     */
    public static byte[] decode2Byte(String ciphertext, String charset) {
        return decode2Byte(ciphertext, Charset.forName(charset));
    }

    /**
     * 解码字符串
     *
     * @param ciphertext
     * @return
     */
    public static byte[] decode2Byte(String ciphertext) {
        return decode2Byte(ciphertext, Charsets.DEFAULT_CHARSET);
    }


    /**
     * 解码字符串
     *
     * @param bytes
     * @return
     */
    public static String decode(byte[] bytes) {
        return new String(decode2Byte(bytes));
    }


    /**
     * 解码字符串
     *
     * @param ciphertext
     * @return
     */
    public static String decode(String ciphertext, Charset charset) {
        return decode(ciphertext.getBytes(charset));
    }

    /**
     * 解码字符串
     *
     * @param ciphertext
     * @return
     */
    public static String decode(String ciphertext, String charset) {
        return decode(ciphertext, Charset.forName(charset));
    }

    /**
     * 解码字符串
     *
     * @param ciphertext
     * @return
     */
    public static String decode(String ciphertext) {
        return decode(ciphertext, Charsets.DEFAULT_CHARSET);
    }

}
