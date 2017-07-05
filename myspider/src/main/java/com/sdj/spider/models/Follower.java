package com.sdj.spider.models;

import java.io.Serializable;
import java.util.Date;

public class Follower implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer followedid;

    private Date followtime;

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

    public Integer getFollowedid() {
        return followedid;
    }

    public void setFollowedid(Integer followedid) {
        this.followedid = followedid;
    }

    public Date getFollowtime() {
        return followtime;
    }

    public void setFollowtime(Date followtime) {
        this.followtime = followtime;
    }
}