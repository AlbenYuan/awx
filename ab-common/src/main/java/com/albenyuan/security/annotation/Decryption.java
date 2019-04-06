package com.albenyuan.security.annotation;


import com.albenyuan.security.crypto.Algorithm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Alben Yuan
 * @Date 2018-05-20 22:39
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Decryption {

    String[] field() default {};

    Algorithm algorithm() default Algorithm.MD5;

}
