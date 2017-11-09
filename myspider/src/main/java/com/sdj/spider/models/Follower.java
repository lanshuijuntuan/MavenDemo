package com.sdj.spider.models;

import java.io.Serializable;
import java.util.Date;

public class Follower implements Serializable {
    private String id;

    private String userid;

    private String followedid;

    private Date followtime;

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

    public String getFollowedid() {
        return followedid;
    }

    public void setFollowedid(String followedid) {
        this.followedid = followedid == null ? null : followedid.trim();
    }

    public Date getFollowtime() {
        return followtime;
    }

    public void setFollowtime(Date followtime) {
        this.followtime = followtime;
    }
}