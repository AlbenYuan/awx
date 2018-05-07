package com.albenyuan.common.security;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Author Alben Yuan
 * @Date 2017-12-25 13:20
 */

public class Base64Util {


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
    public static String encode(String source) {
        return encode(source.getBytes());
    }

    /**
     * 编码文件
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static String encode(File file) throws IOException {
        byte[] bytes = FileUtils.readFileToByteArray(file);
        return encode(bytes);
    }

    /**
     * 解码字符串
     *
     * @param target
     * @return
     */
    public static String decode(String target) {
        return null;
    }

    /**
     * 解码字符串
     *
     * @param bytes
     * @return
     */
    public static String decode(byte[] bytes) {
        return null;
    }

    /**
     * 解码文件
     *
     * @param target
     * @param file
     * @throws Exception
     */
    public static void decode(String target, File file) throws Exception {
//        byte[] targetBs = target.getBytes("UTF-8");
//        byte[] sourceBs = Base64Util.decodeBase64(targetBs);
//        FileUtils.writeByteArrayToFile(io, sourceBs);
    }

    /**
     * 将BASE64字符串恢复为二进制数据
     *
     * @param base64String
     * @return
     */
    public static byte[] decodeBinary(String base64String) {
//        try {
//            return Base64Util.decodeBase64(base64String.getBytes("UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            return null;
//        }
        return null;
    }

}
