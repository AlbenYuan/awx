package com.albenyuan.admin.entity;

import com.albenyuan.entity.TreeEntity;

public class Operation extends TreeEntity<String> {
    
    private String name;

    private String action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }
}