package com.sdj.spider.dao;

import com.sdj.spider.models.BlogUser;

public interface BlogUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    BlogUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogUser record);

    int updateByPrimaryKey(BlogUser record);
    
    BlogUser selectByBlogName(String blogname);
}