package com.sdj.spider.dao;

import com.sdj.spider.models.PostTag;

public interface PostTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostTag record);

    int insertSelective(PostTag record);

    PostTag selectByPrimaryKey(Integer id);
    
    PostTag selectByTagIdAndPostId(String tagid,int postid);

    int updateByPrimaryKeySelective(PostTag record);

    int updateByPrimaryKey(PostTag record);
}