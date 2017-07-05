package com.sdj.spider.models;

import java.io.Serializable;
import java.util.Date;

public class Followee implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer followeeid;

    private Date followeetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFolloweeid() {
        return followeeid;
    }

    public void setFolloweeid(Integer followeeid) {
        this.followeeid = followeeid;
    }

    public Date getFolloweetime() {
        return followeetime;
    }

    public void setFolloweetime(Date followeetime) {
        this.followeetime = followeetime;
    }
}