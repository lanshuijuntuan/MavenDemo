package com.sdj.spider.dao;

import com.sdj.spider.models.Tag;

public interface TagMapper {
    int deleteByPrimaryKey(String id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(String id);
    
    Tag selectByNameAndBlogId(String name,int blogid);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}