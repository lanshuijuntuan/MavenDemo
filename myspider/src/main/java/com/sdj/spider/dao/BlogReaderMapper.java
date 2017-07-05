package com.sdj.spider.dao;

import com.sdj.spider.models.BlogReader;

public interface BlogReaderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogReader record);

    int insertSelective(BlogReader record);

    BlogReader selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogReader record);

    int updateByPrimaryKey(BlogReader record);
}