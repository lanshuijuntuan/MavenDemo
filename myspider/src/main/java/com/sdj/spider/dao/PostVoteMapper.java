package com.sdj.spider.dao;

import com.sdj.spider.models.PostVote;

public interface PostVoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostVote record);

    int insertSelective(PostVote record);

    PostVote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostVote record);

    int updateByPrimaryKey(PostVote record);
}