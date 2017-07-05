package com.sdj.spider.models;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    private Integer id;

    private String title;

    private String content;

    private Integer userid;

    private Date posted;

    private Integer catologid;

    private String blogurl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public Integer getCatologid() {
        return catologid;
    }

    public void setCatologid(Integer catologid) {
        this.catologid = catologid;
    }

    public String getBlogurl() {
        return blogurl;
    }

    public void setBlogurl(String blogurl) {
        this.blogurl = blogurl == null ? null : blogurl.trim();
    }
}