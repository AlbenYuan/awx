package com.albenyuan.entity;

import java.io.Serializable;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 20:49
 */
public class TreeEntity<ID extends Serializable> extends StateEntity<ID> {

    protected ID parentId;

    public ID getParentId() {
        return parentId;
    }

    public void setParentId(ID parentId) {
        this.parentId = parentId;
    }
}
