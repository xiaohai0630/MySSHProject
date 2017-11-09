package com.lanou.job_dep.domain;

import java.util.Date;

/**
 * Created by dllo on 17/9/21.
 */
public class StuJob {
    // 学生就业信息表
    // 和一个学生就业表对应一个学员和一个班级

    private int granduateId;
    private String companyName;
    private double salary;
    private String post;
    private Date entryTime;
    private String remark;

    public StuJob(int granduateId, String companyName, double salary, String post, Date entryTime, String remark) {
        this.granduateId = granduateId;
        this.companyName = companyName;
        this.salary = salary;
        this.post = post;
        this.entryTime = entryTime;
        this.remark = remark;
    }

    public StuJob() {
    }

    public int getGranduateId() {
        return granduateId;
    }

    public void setGranduateId(int granduateId) {
        this.granduateId = granduateId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "StuJob{" +
                "granduateId=" + granduateId +
                ", companyName='" + companyName + '\'' +
                ", salary=" + salary +
                ", post='" + post + '\'' +
                ", entryTime=" + entryTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
