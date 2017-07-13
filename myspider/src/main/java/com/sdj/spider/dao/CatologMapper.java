package com.sdj.spider.dao;

import com.sdj.spider.models.Catolog;

public interface CatologMapper {
    int deleteByPrimaryKey(String id);

    int insert(Catolog record);

    int insertSelective(Catolog record);

    Catolog selectByPrimaryKey(String id);
    
    Catolog selectByNameAndBlogId(String name,int blogid);

    int updateByPrimaryKeySelective(Catolog record);

    int updateByPrimaryKey(Catolog record);
}