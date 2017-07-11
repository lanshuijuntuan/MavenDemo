package com.sdj.spider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Json;
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
			Json pagejson = page.getJson();

			if (map.containsKey(selectable.toString())) {
				page.setSkip(true);
				return;
			} else {
				String title = html.xpath("/html/head/title").get();
				map.put(selectable.toString(), title);
			}

			// 符合帖子标准
			// 获取帖子信息
			if (selectable.regex("http://www.cnblogs.com/[a-z 0-9 -]+/p/[a-z 0-9 -]+.html").match()) {
				page.putField("pagetype", PageType.Detail);
				JSONObject jsonObject = new JSONObject();
				// post_url
				jsonObject.put("post_url", selectable.get());
				// post_title
				jsonObject.put("post_title",
						html.xpath(String.format("//a[@href='%s']/text()", selectable.get())).get());

				jsonObject.put("post_content",
						html.xpath(String.format("//a[@href='%s']/text()", selectable.get())).get());

				List<Selectable> nodes = html.css("script:not([src])").nodes();
				String blogname = "";
				String cb_blogId = "";
				String cb_entryId = "";
				String cb_blogUserGuid = "";
				String cb_entryCreatedDate = "";
				for (Selectable node : nodes) {
					if (node.get().contains("var currentBlogApp =")) {
						blogname = node.xpath("script/html()").regex("var currentBlogApp = '.{1,20}',").get()
								.replace("var currentBlogApp = '", "").replace("',", "");

						jsonObject.put("blog_name", blogname);
						jsonObject.put("blog_homepage", String.format("http://www.cnblogs.com/%s/", blogname));
					} else if (node.get().contains(",cb_blogId=")) {

						cb_blogUserGuid = node.xpath("script/html()").regex(",cb_blogUserGuid='.{1,50}',").get()
								.replace(",cb_blogUserGuid='", "").replace("',", "");

						jsonObject.put("bloguser_id", cb_blogUserGuid);

						cb_blogId = node.xpath("script/html()").regex(",cb_blogId=[0-9]{1,20},").get()
								.replace(",cb_blogId=", "").replace(",", "");

						jsonObject.put("blog_id", cb_blogId);

						cb_entryId = node.xpath("script/html()").regex(",cb_entryId=.{1,20},").get()
								.replace(",cb_entryId=", "").replace(",", "");
						jsonObject.put("post_id", cb_entryId);

						cb_entryCreatedDate = node.xpath("script/html()").regex(",cb_entryCreatedDate='.{1,20}'").get()
								.replace(",cb_entryCreatedDate='", "").replace("'", "").trim();

						jsonObject.put("post_posted", DateUtils.parseDate(cb_entryCreatedDate, "yyyy/MM/dd HH:mm:ss"));
					}
				}

				page.addTargetRequest(String.format("http://www.cnblogs.com/mvc/blog/news.aspx?blogApp=%s", blogname));
				page.addTargetRequest(String.format(
						"http://www.cnblogs.com/mvc/blog/CategoriesTags.aspx?blogApp=%s&blogId=%s&postId=%s&_=%s",
						blogname, cb_blogId, cb_entryId, String.valueOf(System.currentTimeMillis())));
				page.addTargetRequest(String.format("http://www.cnblogs.com/%s/mvc/blog/sidecolumn.aspx?blogApp=%s",
						blogname, blogname));
				// http://www.cnblogs.com/post/prevnext?postId=5765624&blogId=84872&dateCreated=2016%2F8%2F12+16%3A53%3A00
				page.addTargetRequest(
						String.format("http://www.cnblogs.com/post/prevnext?postId=%s&blogId=%s&dateCreated=%s",
								cb_entryId, cb_blogId, cb_entryCreatedDate));

				page.putField("data", jsonObject);

			}
			// http://www.cnblogs.com/post/prevnext?postId=5765624&blogId=84872&dateCreated=2016%2F8%2F12+16%3A53%3A00
			// 获取上下文
			else if (selectable.get().contains("http://www.cnblogs.com/post/prevnext?")) {
				page.addTargetRequests(html.links().regex("http://www.cnblogs.com/[a-z 0-9 -]+/p/[0-9]{7}.html").all());
			}
			// http://www.cnblogs.com/softidea/mvc/blog/sidecolumn.aspx?blogApp=softidea
			// 获取侧边栏
			else if (selectable.get().contains("/mvc/blog/sidecolumn.aspx?blogApp=")
					&& selectable.get().contains("http://www.cnblogs.com/")) {
				String blogname = selectable.get().split("=")[1].replace("blogApp=", "");

				page.addTargetRequests(html.links()
						.regex(String.format("http://www.cnblogs.com/%s/tag/[a-z 0-9 -]+/", blogname)).all());
			} else if (selectable.regex("http://www.cnblogs.com/[a-z 0-9 -]+/tag/[a-z 0-9 -]+/").match()) {
				page.addTargetRequests(
						html.links().regex("http://www.cnblogs.com/[a-z 0-9 -]+/p/[0-9]{7}.html").all());
			}
			// http://www.cnblogs.com/mvc/blog/news.aspx?blogApp=%s
			// 获取通知信息
			else if (selectable.get().contains("http://www.cnblogs.com/mvc/blog/news.aspx?blogApp=")) {
				page.putField("pagetype", PageType.Detail_New);
				JSONObject jsonObject = new JSONObject();
				String blogname = selectable.get().replace("http://www.cnblogs.com/mvc/blog/news.aspx?blogApp=", "");
				String nickname = html.$("#profile_block > a:nth-child(1)").xpath("a/text()").get();
				String authorRegTime = html.$("#profile_block > a:nth-child(3)").xpath("a/@title").get()
						.replace("入园时间：", "").trim();
				jsonObject.put("blog_name", blogname);
				jsonObject.put("bloguser_nickname", nickname);
				jsonObject.put("bloguser_regtime", DateUtils.parseDate(authorRegTime, "yyyy-MM-dd"));
				page.putField("data", jsonObject);

			}
			// http://www.cnblogs.com/mvc/blog/CategoriesTags.aspx?blogApp=%s&blogId=%s&postId=%s&_=%s
			// 获取分类信息
			else if (selectable.get().contains("http://www.cnblogs.com/mvc/blog/CategoriesTags.aspx?")) {
				page.putField("pagetype", PageType.Detail_TagAndCategory);
				JSONObject jsonObject = new JSONObject();
				String[] queryparas = selectable.get()
						.replace("http://www.cnblogs.com/mvc/blog/CategoriesTags.aspx?", "").split("&");
				for (String querypara : queryparas) {
					if (querypara.contains("blogApp=")) {
						String blogAppPara = querypara.replace("blogApp=", "");
						jsonObject.put("blog_name", blogAppPara);

					}
					if (querypara.contains("blogId=")) {
						String blogIdPara = querypara.replace("blogId=", "");
						jsonObject.put("blog_id", blogIdPara);
					}
					if (querypara.contains("postId=")) {
						String postIdPara = querypara.replace("postId=", "");
						jsonObject.put("post_id", postIdPara);
					}
				}

				String tags = pagejson.jsonPath("Tags").get();

				if (tags.contains("标签:")) {
					// 标签
					JSONArray tagjsonArray = new JSONArray();
					String[] tagArray = tags.replace("标签:", "").trim().split(",");
					for (String tag : tagArray) {
						Document doc = Jsoup.parse(tag);
						String tagstr = doc.text().trim();
						if (StringUtils.isEmpty(tagstr) || tagstr == null) {
							continue;
						}
						tagjsonArray.add(tagstr);
					}
					jsonObject.put("post_tags", tagjsonArray);
				}

				String categories = pagejson.jsonPath("Categories").get();

				if (categories.contains("分类: ")) {
					String[] categoryArray = categories.replace("分类:", "").trim().split(",");
					// 分类
					JSONArray categoryjsonArray = new JSONArray();
					for (String category : categoryArray) {
						Document doc = Jsoup.parse(category);
						String categorystr = doc.text().trim();
						if (StringUtils.isEmpty(categorystr) || categorystr == null) {
							continue;
						}
						categoryjsonArray.add(categorystr);
					}
					jsonObject.put("post_categories", categoryjsonArray);
				}
				page.putField("data", jsonObject);
			}
			// 符合
			else {
				Selectable selectablelinks = html.links();
				page.addTargetRequests(
						selectablelinks.regex("http://www.cnblogs.com/[a-z 0-9 -]+/p/[0-9]{7}.html").all());
				page.addTargetRequests(selectablelinks.regex("http://www.cnblogs.com/sitehome/p/[0-9]{1,7}").all());
			}

		} catch (Exception e) {
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
			/*
			 * String phantomjsCommand = System.getProperty("user.dir") +
			 * "\\src\\main\\resources\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe";
			 */
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
