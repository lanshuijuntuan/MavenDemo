package com.sdj.spider.models;

import java.io.Serializable;
import java.util.Date;

public class PostViewer implements Serializable {
    private Integer id;

    private Integer postid;

    private String userid;

    private String address;

    private Date readertime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
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