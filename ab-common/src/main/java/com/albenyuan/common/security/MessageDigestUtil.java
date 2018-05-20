package com.albenyuan.common.security;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author Alben Yuan
 * @Date 2018-05-19 18:45
 */
public class MessageDigestUtil {


    public enum Algorithm {

        MD2("MD2"),
        MD5("MD5"),
        SHA("SHA"),
        SHA_1("SHA-1"),
        SHA_224("SHA-224"),
        SHA_384("SHA-384"),
        SHA_512("SHA-512");

        private String value;

        Algorithm(String value) {
            this.value = value;
        }

    }

    private MessageDigestUtil() {
    }


    public static byte[] encode(byte[] bytes, Algorithm algorithm) {
        if (null != bytes) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(algorithm.value);
                messageDigest.update(bytes);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
