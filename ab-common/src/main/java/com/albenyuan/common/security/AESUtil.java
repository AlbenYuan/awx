package com.albenyuan.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @Author Alben Yuan
 * @Date 2017-12-25 13:10
 */

public class AESUtil {

    private static Logger logger = LoggerFactory.getLogger(AESUtil.class);

    public static final String ALGORITHM = "AES";


    /**
     * 加密
     *
     * @param plaintext 需要加密的内容
     * @param password  加密密码
     * @return
     */
    public static byte[] encrypt(String plaintext, String password) {
        return encrypt(plaintext.getBytes(), password);
    }

    /**
     * 加密
     *
     * @param plaintext 需要加密的内容
     * @param secret    加密密码
     * @return
     */
    public static byte[] encrypt(byte[] plaintext, String secret) {
        return encrypt(plaintext, secret.getBytes());
    }


    /**
     * 加密
     *
     * @param plaintext 需要加密的内容
     * @param secret    加密密码
     * @return
     */
    public static byte[] encrypt(byte[] plaintext, byte[] secret) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(128, new SecureRandom(secret));
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);// 创建密码器
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(plaintext);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }


    /**
     * 解密
     *
     * @param ciphertext 待解密内容
     * @param secret     解密密钥
     * @return
     */
    public static byte[] decrypt(String ciphertext, String secret) {
        return decrypt(ciphertext.getBytes(), secret);
    }

    /**
     * 解密
     *
     * @param ciphertext 待解密内容
     * @param secret     解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] ciphertext, String secret) {
        return decrypt(ciphertext, secret.getBytes());
    }


    /**
     * 解密
     *
     * @param ciphertext 待解密内容
     * @param secret     解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] ciphertext, byte[] secret) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
            kgen.init(128, new SecureRandom(secret));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(ciphertext);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
