package com.sdj.spider.models;

import java.io.Serializable;
import java.util.Date;

public class BlogReader implements Serializable {
    private Integer id;

    private Integer blogid;

    private Integer userid;

    private String address;

    private Date readertime;

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getReadertime() {
        return readertime;
    }

    public void setReadertime(Date readertime) {
        this.readertime = readertime;
    }
}