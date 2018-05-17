package com.albenyuan.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Alben Yuan
 * @Date 2018-01-29 14:09
 */

public class ReflectionUtil {

    public static Map<String, Object> object2Map(Object o) throws IllegalArgumentException, IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        if (null != o) {
            Class clazz = o.getClass();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(o));
            }
        }
        return map;
    }

    public static <T> T map2Object(Map<String, Object> map, Class<T> clazz) throws Exception {
        if (map == null) {
            return null;
        }
        T t = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            field.set(t, map.get(field.getName()));
        }
        return t;
    }

    public List<Field> getFields(Class<?> clazz) {
        return Arrays.asList(clazz.getFields());
    }

    private ReflectionUtil() {
    }

}
