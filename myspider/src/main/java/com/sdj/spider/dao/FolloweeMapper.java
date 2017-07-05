package com.sdj.spider.dao;

import com.sdj.spider.models.Followee;

public interface FolloweeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Followee record);

    int insertSelective(Followee record);

    Followee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Followee record);

    int updateByPrimaryKey(Followee record);
}