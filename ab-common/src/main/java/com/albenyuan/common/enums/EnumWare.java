package com.albenyuan.common.enums;

/**
 * @Author Alben Yuan
 * @Date 2018-04-14 23:17
 */
public abstract class EnumWare<T> {

    public abstract String getName();

    public abstract T getValue(String name);
}
