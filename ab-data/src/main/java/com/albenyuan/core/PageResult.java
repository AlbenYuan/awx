package com.albenyuan.core;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 20:57
 */
public class PageResult<T extends Serializable> {

    private int size; //  数量

    private int page; // 页码， 从1开始

    private long total; // 总记录数

    private boolean next;

    private boolean preview;


    private List<T> data;

//    private int
}
