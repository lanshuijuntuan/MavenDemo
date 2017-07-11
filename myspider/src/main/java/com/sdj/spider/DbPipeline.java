package com.sdj.spider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sdj.spider.dao.BlogMapper;
import com.sdj.spider.dao.BlogUserMapper;
import com.sdj.spider.dao.CatologMapper;
import com.sdj.spider.dao.PostMapper;
import com.sdj.spider.dao.PostTagMapper;
import com.sdj.spider.dao.TagMapper;
import com.sdj.spider.models.Blog;
import com.sdj.spider.models.BlogUser;
import com.sdj.spider.models.Catolog;
import com.sdj.spider.models.Post;
import com.sdj.spider.models.PostTag;
import com.sdj.spider.models.Tag;

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
		if (resultItems.get("pagetype") == null) {
			return;
		}
		if (resultItems.get("data") == null) {
			return;
		}

		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int pagetype = resultItems.get("pagetype");
			JSONObject data = resultItems.get("data");

			switch (pagetype) {
			case PageType.Detail: {
				String userid = data.getString("bloguser_id");
				BlogUserMapper blogUserMapper = sqlSession.getMapper(BlogUserMapper.class);
				BlogUser blogUser = blogUserMapper.selectByPrimaryKey(userid);
				if (blogUser == null) {
					blogUser = new BlogUser();
					blogUser.setId(userid);
					blogUserMapper.insert(blogUser);
				}
				int blogid = data.getInteger("blog_id");
				BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
				Blog blog = blogMapper.selectByPrimaryKey(blogid);
				if (blog == null) {
					blog = new Blog();
					blog.setId(blogid);
					blog.setBlogname(data.getString("blog_name"));
					blog.setHomepage(data.getString("blog_homepage"));
					blog.setSign(data.getString("blog_sign'"));
					blog.setUserid(userid);
					blogMapper.insert(blog);
				}
				int postid = data.getIntValue("post_id");
				PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
				Post post = postMapper.selectByPrimaryKey(postid);
				if (post == null) {
					post = new Post();
					post.setBlogid(blogid);
					post.setId(postid);
					post.setPosturl(data.getString("post_url"));
					post.setTitle(data.getString("post_title"));
					post.setContent(data.getString("post_content"));
					post.setPosted(data.getDate("post_posted"));
					postMapper.insert(post);
				}
				sqlSession.commit();
				break;
			}
			case PageType.Detail_New: {
				String blogname = data.getString("blog_name");
				String nickname = data.getString("bloguser_nickname");
				Date regtime = data.getDate("bloguser_regtime");
				BlogUserMapper blogUserMapper = sqlSession.getMapper(BlogUserMapper.class);
				BlogUser blogUser = blogUserMapper.selectByBlogName(blogname);
				if (blogUser != null) {
					blogUser.setNickname(nickname);
					blogUser.setRegtime(regtime);
				}
				sqlSession.commit();
				break;
			}
			case PageType.Detail_TagAndCategory: {
				String blogname=data.getString("blog_name");
				int blogid=data.getInteger("blog_id");
				int postid=data.getInteger("post_id");
				BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
				PostMapper postMapper=sqlSession.getMapper(PostMapper.class);
				TagMapper tagMapper=sqlSession.getMapper(TagMapper.class);
				PostTagMapper postTagMapper=sqlSession.getMapper(PostTagMapper.class);
				CatologMapper catologMapper=sqlSession.getMapper(CatologMapper.class);
				Blog blog=blogMapper.selectByPrimaryKey(blogid);
				Post post=postMapper.selectByPrimaryKey(postid);
				if(blog==null||post==null)
				{
					return;
				}
				JSONArray tagArray=(JSONArray)data.get("post_tags");
				JSONArray categoryArray=(JSONArray)data.get("post_categories");
				for(int i=0;i<tagArray.size();i++)
				{
					String tagName=tagArray.getString(i).trim();
					Tag tag=tagMapper.selectByNameAndBlogId(tagName, blogid);
					if(tag==null)
					{
						tag=new Tag();
						tag.setName(tagName);
						tag.setBlogid(blogid);
						String tagid=UUID.randomUUID().toString();
						tag.setId(UUID.randomUUID().toString());
						tagMapper.insert(tag);
						
						PostTag postTag=new PostTag();
						postTag.setPostid(postid);
						postTag.setTagid(tagid);
						postTagMapper.insert(postTag);
						
					}
					else
					{
						PostTag postTag=postTagMapper.selectByTagIdAndPostId(tag.getId(), postid);
						if(postTag==null)
						{
							postTag=new PostTag();
							postTag.setPostid(postid);
							postTag.setTagid(tag.getId());
							postTagMapper.insert(postTag);
							
						}
					}
				}
				
				for(int i=0;i<categoryArray.size();i++)
				{
					String categoryname=categoryArray.getString(i);
					Catolog catolog=catologMapper.selectByNameAndBlogId(categoryname, blogid);
					if(catolog==null)
					{
						catolog=new Catolog();
						catolog.setName(categoryname);
						catolog.setBlogid(blogid);
						String catologid=UUID.randomUUID().toString();
						catolog.setId(catologid);
						catologMapper.insert(catolog);
						post.setCatolog(catologid);
						postMapper.updateByPrimaryKey(post);
					}
					else
					{
						post.setCatolog(catolog.getId());
						postMapper.updateByPrimaryKey(post);
					}
					
				}
				
				sqlSession.commit();
				break;
			}
			default: {
				break;
			}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

}
