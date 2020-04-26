package com.example.my.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author hufei
 * @date 2020/4/18
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}