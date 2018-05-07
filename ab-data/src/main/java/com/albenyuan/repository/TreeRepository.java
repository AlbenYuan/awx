package com.albenyuan.repository;

import com.albenyuan.entity.TreeEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 20:50
 */
public interface TreeRepository<T extends TreeEntity<ID>, ID extends Serializable>
        extends StateRepository<T, ID> {

    List<T> findByParentId(ID parentId);

}
