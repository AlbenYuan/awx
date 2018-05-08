package com.albenyuan.web.service;

import com.albenyuan.entity.TreeEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 21:38
 */
public interface TreeService<T extends TreeEntity<ID>, ID extends Serializable>
        extends StateService<T, ID> {
    
    List<T> findByParentId(ID parentId);


}
