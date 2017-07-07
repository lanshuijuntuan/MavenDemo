package com.sdj.spider.models;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {
    private Integer id;

    private String title;

    private String content;

    private String userid;

    private Date posted;

    private Integer catologid;

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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
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

    public String getPosturl() {
        return posturl;
    }

    public void setPosturl(String posturl) {
        this.posturl = posturl == null ? null : posturl.trim();
    }
}