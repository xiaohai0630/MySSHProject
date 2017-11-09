package com.lanou.ask_dep.domain;

import java.util.Date;

/**
 * Created by dllo on 17/9/21.
 */
public class StuFollow {
    // 多个学生跟踪表对应一个学生咨询表

    private int followId;
    private Date followTime;
    private String content;

    // 关系
    // 多个跟踪表对应一个咨询表
    private StuAsk stuAsk;

    public StuAsk getStuAsk() {
        return stuAsk;
    }

    public void setStuAsk(StuAsk stuAsk) {
        this.stuAsk = stuAsk;
    }

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 学生跟踪表
    public StuFollow(int followId, Date followTime, String content) {
        this.followId = followId;
        this.followTime = followTime;
        this.content = content;
    }

    public StuFollow() {
    }

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "StuFollow{" +
                "followId=" + followId +
                ", followTime=" + followTime +
                ", content='" + content + '\'' +
                '}';
    }
}
