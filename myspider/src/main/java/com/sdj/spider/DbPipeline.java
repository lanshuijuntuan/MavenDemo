package com.sdj.spider;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sdj.spider.dao.PostMapper;
import com.sdj.spider.dao.UserMapper;
import com.sdj.spider.models.Post;
import com.sdj.spider.models.User;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class DbPipeline implements Pipeline {

	static {
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static SqlSessionFactory sqlSessionFactory;

	public void process(ResultItems resultItems, Task task) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			if (resultItems.get("user") == null) {
				return;
			}
			User user=resultItems.get("user");
			if(resultItems.get("post")==null)
			{
				return;
			}
			Post post=resultItems.get("post");
			if(StringUtils.isNotBlank(user.getId())&&user.getId()!=null)
			{
				UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
				userMapper.insert(user);
				
			}
			if(post.getId()>0)
			{
				PostMapper postMapper=sqlSession.getMapper(PostMapper.class);
				postMapper.insert(post);
			}
			sqlSession.commit();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

}
