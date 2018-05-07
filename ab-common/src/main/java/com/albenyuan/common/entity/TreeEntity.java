package com.albenyuan.common.entity;

/**
 * @Author Alben Yuan
 * @Date 2018-01-26 17:34
 */
public class TreeEntity extends BaseEntity {

    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
