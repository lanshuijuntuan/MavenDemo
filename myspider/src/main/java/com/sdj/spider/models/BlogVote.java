package com.sdj.spider.models;

import java.io.Serializable;
import java.util.Date;

public class BlogVote implements Serializable {
    private Integer id;

    private Integer blogid;

    private Boolean issupport;

    private Date votetime;

    private Integer userid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public Boolean getIssupport() {
        return issupport;
    }

    public void setIssupport(Boolean issupport) {
        this.issupport = issupport;
    }

    public Date getVotetime() {
        return votetime;
    }

    public void setVotetime(Date votetime) {
        this.votetime = votetime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}