package com.lanou.hr_dep.domain;

import java.util.Date;

/**
 * Created by dllo on 17/9/21.
 */
public class Staff {
    /**
     * 员工信息表
     * 员工编号（主键staffID）
     * 登录名、登录密码、员工姓名、员工性别、入职时间
     *
     * 关联关系：
     * 多个员工属于同一个职务
     * 写的是Post
     */
    private int staffID;
    private String loginName;
    private String loginPwd;
    private String staffName;
    private String gender;
    private Date onDutyDate;

    // 多个员工属于同一个职务
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    // 构造方法
    public Staff(int staffID, String loginName, String loginPwd, String staffName, String gender, Date onDutyDate) {
        this.staffID = staffID;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;
    }

    public Staff() {

    }

    // get、set方法
    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffId) {
        this.staffID = staffId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }

    // 加上职员
    @Override
    public String toString() {
        return "Staff{" +
                "staffID=" + staffID +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", staffName='" + staffName + '\'' +
                ", gender='" + gender + '\'' +
                ", onDutyDate=" + onDutyDate +
                ", post=" + post +
                '}';
    }

}
