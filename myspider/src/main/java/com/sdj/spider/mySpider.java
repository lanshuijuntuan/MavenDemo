package com.sdj.spider;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

import com.sdj.spider.models.Post;
import com.sdj.spider.models.User;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.PhantomJSDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class mySpider implements PageProcessor {

	private Site site = Site.me()
			.setUserAgent(
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36")
			.setRetryTimes(3).setSleepTime(800);

	public static int count = 0;

	public static Map<String, String> map = new HashMap<String, String>();

	public void process(Page page) {
		// TODO Auto-generated method stub
		try {
			Selectable selectable = page.getUrl();
			Html html = page.getHtml();

			if (map.containsKey(selectable.toString())) {
				page.setSkip(true);
				return;
			} else {
				String title = html.xpath("/html/head/title").get();
				map.put(selectable.toString(), title);
			}

			// 符合帖子标准
			if (selectable.regex("http://www.cnblogs.com/[a-z 0-9 -]+/p/[a-z 0-9 -]+.html").match()) {
				User user = new User();

				Post post = new Post();

				// 链接
				post.setPosturl(selectable.get());
				// 标题
				post.setTitle(html.xpath(String.format("//a[@href='%s']/text()", post.getPosturl())).get());
				// 内容
				/*
				 * post.setContent(html.xpath(String.format(
				 * "//div[@id='%s']/text()", "cnblogs_post_body")).get()
				 * .substring(0, 200));
				 */
				post.setContent(html.xpath(String.format("//a[@href='%s']/text()", post.getPosturl())).get());
				// 时间

			/*	post.setPosted(
						DateUtils.parseDate(html.xpath("//span[@id='post-date']/text()").get(), "yyyy-MM-dd HH:mm"));*/
				List<Selectable> nodes = html.css("script:not([src])").nodes();
				String blogname = "";
				for (Selectable node : nodes) {

					if (node.get().contains("var currentBlogApp =")) {
						blogname = node.xpath("script/html()").regex("var currentBlogApp = '.{1,20}',").get()
								.replace("var currentBlogApp = '", "").replace("',", "");
						user.setBlogname(blogname);
					} else if (node.get().contains(",cb_blogId=")) {
						String cb_blogId = node.xpath("script/html()").regex(",cb_blogId=[0-9]{1,20},").get()
								.replace(",cb_blogId=", "").replace(",", "");
						user.setBlogid(Integer.parseInt(cb_blogId));
						String cb_entryId = node.xpath("script/html()").regex(",cb_entryId=.{1,20},").get()
								.replace(",cb_entryId=", "").replace(",", "");

						post.setId(Integer.parseInt(cb_entryId));
						String cb_blogUserGuid = node.xpath("script/html()").regex(",cb_blogUserGuid='.{1,50}',").get()
								.replace(",cb_blogUserGuid='", "").replace("',", "");
						user.setId(cb_blogUserGuid);
						String cb_entryCreatedDate = node.xpath("script/html()").regex(",cb_entryCreatedDate='.{1,20}'")
								.get().replace(",cb_entryCreatedDate='", "").replace("'", "").trim();
						post.setPosted(DateUtils.parseDate(cb_entryCreatedDate, "yyyy/MM/dd HH:mm:ss"));
					}

				}

				post.setUserid(user.getId());

				user.setHomepage(String.format("http://www.cnblogs.com/%s/", blogname));

				page.addTargetRequest(String.format("http://www.cnblogs.com/mvc/blog/news.aspx?blogApp=%s", blogname));

				// String nickName =
				// html.xpath("//*[@id=\"profile_block\"]/a[1]/text()").get();
				// // 设置昵称
				// user.setNickname(nickName);
				//
				// String authorRegTime =
				// html.xpath("//*[@id=\"profile_block\"]/a[2]/@title").get().replace("入园时间：",
				// "")
				// .trim();
				//
				// // 设置注册时间
				// user.setRegtime(DateUtils.parseDate(authorRegTime,
				// "yyyy-MM-dd"));

				page.putField("user", user);
				page.putField("post", post);

			} else if (selectable.get().contains("http://www.cnblogs.com/mvc/blog/news.aspx?blogApp=")) {
				String blogname = selectable.get().replace("http://www.cnblogs.com/mvc/blog/news.aspx?blogApp=", "");
				String nickname = html.$("#profile_block > a:nth-child(1)").xpath("a/text()").get();
				String authorRegTime = html.$("#profile_block > a:nth-child(3)").xpath("a/@title").get()
						.replace("入园时间：", "").trim();
				User user=new User();
				user.setId("-1");
				user.setNickname(nickname);
				user.setBlogname(blogname);
				user.setRegtime(DateUtils.parseDate(authorRegTime, "yyyy-MM-dd"));
				page.putField("user", user);
				System.out.println("nickname:" + nickname + " authorRegTime:" + authorRegTime);
			}
			// 符合
			else {
				Selectable selectablelinks = html.links();

				page.addTargetRequests(
						selectablelinks.regex("http://www.cnblogs.com/[a-z 0-9 -]+/p/[0-9]{7}.html").all());
				page.addTargetRequests(selectablelinks.regex("http://www.cnblogs.com/sitehome/p/[0-9]{1,7}").all());

			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			count++;
		}

	}

	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			long starttime, endtime;
			System.out.println("开始抓取网页");
			starttime = System.currentTimeMillis();

			// System.setProperty("selenuim_config", "config.ini");
			String phantomjsCommand = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe";
			Spider.create(new mySpider()).addUrl("http://www.cnblogs.com/").addPipeline(new DbPipeline())
					.setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
					// .setDownloader(new
					// SeleniumDownloader("chromedriver/chromedriver.exe"))
					// .setDownloader(new PhantomJSDownloader(phantomjsCommand))
					.thread(5).run();
			endtime = System.currentTimeMillis();
			System.out.println("爬取结束，耗时约" + ((endtime - starttime) / 1000) + "秒，抓取了" + mySpider.count + "条记录");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
