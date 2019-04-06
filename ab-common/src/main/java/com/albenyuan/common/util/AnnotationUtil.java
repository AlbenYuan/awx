package com.albenyuan.common.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author Alben Yuan
 * @Date 2018-05-17 12:44
 */
public class AnnotationUtil {

    private AnnotationUtil() {
    }

    public static <T extends Annotation> T getAnnotation(Method method, Class<T> clazz) {
        return getAnnotation(method, clazz, false);
    }

    public static <T extends Annotation> T getAnnotation(Method method, Class<T> clazz, boolean fromType) {
        T t = method.getAnnotation(clazz);
        if (null == t && fromType) {
            t = method.getDeclaringClass().getAnnotation(clazz);
        }
        return t;
    }


}
