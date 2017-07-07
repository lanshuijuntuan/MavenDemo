package com.sdj.spider.dao;

import com.sdj.spider.models.PostViewer;

public interface PostViewerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostViewer record);

    int insertSelective(PostViewer record);

    PostViewer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostViewer record);

    int updateByPrimaryKey(PostViewer record);
}