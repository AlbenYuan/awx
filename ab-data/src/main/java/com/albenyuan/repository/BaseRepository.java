package com.albenyuan.repository;

import com.albenyuan.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-05-04 17:19
 */
public interface BaseRepository<T extends BaseEntity<ID>, ID extends Serializable> {

    List<T> findById(String id);

    List<T> findAll();

}
