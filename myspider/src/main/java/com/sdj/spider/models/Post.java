package com.sdj.spider.models;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {
    private Integer id;

    private String title;

    private String content;

    private Integer blogid;

    private Date posted;

    private String catolog;

    private String posturl;

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

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public String getCatolog() {
        return catolog;
    }

    public void setCatolog(String catolog) {
        this.catolog = catolog == null ? null : catolog.trim();
    }

    public String getPosturl() {
        return posturl;
    }

    public void setPosturl(String posturl) {
        this.posturl = posturl == null ? null : posturl.trim();
    }
}