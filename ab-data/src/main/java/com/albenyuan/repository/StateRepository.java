package com.albenyuan.repository;

import com.albenyuan.entity.StateEntity;

import java.io.Serializable;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 20:50
 */
public interface StateRepository<T extends StateEntity<ID>, ID extends Serializable> extends BaseRepository<T, ID> {
}
