package com.albenyuan.web.service;

import com.albenyuan.entity.StateEntity;

import java.io.Serializable;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 21:33
 */
public interface StateService<T extends StateEntity<ID>, ID extends Serializable>
        extends BaseService<T, ID> {


}
