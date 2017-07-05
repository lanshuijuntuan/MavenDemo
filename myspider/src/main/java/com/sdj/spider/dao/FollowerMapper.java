package com.sdj.spider.dao;

import com.sdj.spider.models.Follower;

public interface FollowerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Follower record);

    int insertSelective(Follower record);

    Follower selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Follower record);

    int updateByPrimaryKey(Follower record);
}