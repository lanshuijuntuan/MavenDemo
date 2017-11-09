package com.sdj.spider.models;

import java.io.Serializable;
import java.util.Date;

public class Followee implements Serializable {
    private String id;

    private String userid;

    private String followeeid;

    private Date followeetime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getFolloweeid() {
        return followeeid;
    }

    public void setFolloweeid(String followeeid) {
        this.followeeid = followeeid == null ? null : followeeid.trim();
    }

    public Date getFolloweetime() {
        return followeetime;
    }

    public void setFolloweetime(Date followeetime) {
        this.followeetime = followeetime;
    }
}