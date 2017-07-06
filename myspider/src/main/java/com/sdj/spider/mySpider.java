package com.sdj.spider;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

import com.sdj.spider.models.Blog;
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
			.setRetryTimes(3).setSleepTime(400);

	public static int count = 0;

	public static Map<String, String> map = new HashMap<String, String>();

	public void process(Page page) {
		// TODO Auto-generated method stub

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
		/*
		 * if (selectable.regex(
		 * "http://www.cnblogs.com/[a-z 0-9 -]+/p/[0-9]{7}.html").match()) {
		 * 
		 * page.putField("pageurl", selectable.toString()); String
		 * author=selectable.toString().replace("http://www.cnblogs.com/",
		 * "").split("/")[0]; if(author==null||author.equals("")) {
		 * System.out.println("发现空作者："+selectable.get()); author=""; }
		 * page.putField("author", author); page.putField("title",
		 * html.xpath("/html/head/title/text()").get()); }
		 */
		// 符合帖子标准
		if (selectable.regex("http://www.cnblogs.com/[a-z 0-9 -]+/p/[a-z 0-9 -]+.html").match()) {
			User user = new User();

			Blog blog = new Blog();

			// 链接
			blog.setBlogurl(selectable.get());
			// 标题
			blog.setTitle(html.xpath(String.format("//a[@href='%s']/text()", blog.getBlogurl())).get());
			// 内容
			blog.setContent(html.xpath(String.format("//div[@id='%s']", "cnblogs_post_body")).get());
			// 时间
			try {
				blog.setPosted(
						DateUtils.parseDate(html.xpath("//span[@id='post-date']/text()").get(), "yyyy-MM-dd HH:mm"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String author = selectable.toString().replace("http://www.cnblogs.com/", "").split("/")[0];
			if (author == null || author.equals("")) {
				System.out.println("发现空作者：" + selectable.get());
				author = "";
			}
			user.setName(author);

			user.setHomepage(String.format("http://www.cnblogs.com/%s/", author));

			user.setIntegral(0);

			String authorName = html.xpath("//*[@id=\"profile_block\"]/a[1]/text()").get();
			// 设置昵称
			user.setNickname(authorName);

			String authorRegTime = html.xpath("//*[@id=\"profile_block\"]/a[2]/@title").get().replace("入园时间：", "")
					.trim();
			try {
				// 设置注册时间
				user.setRegtime(DateUtils.parseDate(authorRegTime, "yyyy-MM-dd"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String xpathFollowers = String.format("//a[@href='http://home.cnblogs.com/u/%s/followers/']/text()",
					author);
			int followers = Integer.parseInt(html.xpath(xpathFollowers).get());
			String xpathFollewees = String.format("http://home.cnblogs.com/u/%s/followees/", author);
			int follweees = Integer.parseInt(html.xpath(xpathFollewees).get());

		}
		// 符合
		else {
			Selectable selectablelinks = html.links();

			page.addTargetRequests(selectablelinks.regex("http://www.cnblogs.com/[a-z 0-9 -]+/p/[0-9]{7}.html").all());
			page.addTargetRequests(selectablelinks.regex("http://www.cnblogs.com/sitehome/p/[0-9]{1,7}").all());

		}
		count++;

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
					.setDownloader(new PhantomJSDownloader(phantomjsCommand)).thread(5).run();
			endtime = System.currentTimeMillis();
			System.out.println("爬取结束，耗时约" + ((endtime - starttime) / 1000) + "秒，抓取了" + mySpider.count + "条记录");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
