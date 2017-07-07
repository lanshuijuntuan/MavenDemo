package com.sdj.spider.dao;

import com.sdj.spider.models.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);
    
    User selectByBlogName(String blogname);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}