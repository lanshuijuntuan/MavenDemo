package com.sdj.spider.dao;

import com.sdj.spider.models.Catolog;

public interface CatologMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Catolog record);

    int insertSelective(Catolog record);

    Catolog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Catolog record);

    int updateByPrimaryKey(Catolog record);
}