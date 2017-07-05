package com.sdj.spider.dao;

import com.sdj.spider.models.BlogVote;

public interface BlogVoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogVote record);

    int insertSelective(BlogVote record);

    BlogVote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogVote record);

    int updateByPrimaryKey(BlogVote record);
}