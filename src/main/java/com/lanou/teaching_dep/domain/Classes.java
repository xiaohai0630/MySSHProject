package com.lanou.teaching_dep.domain;

import com.lanou.ask_dep.domain.StuAsk;
import com.lanou.plan_dep.domain.Student;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/9/21.
 */
public class Classes {
    /**
     * 班级表
     * 多个班级可以上同样的课
     * 主键classID
     */

    private int classID;
    private String name;
    private Date beginTime;
    private Date endTime;
    private int totalCount;
    private int upgradeCount;
    private int changeCount;
    private int runoffCount;
    private String remark;
    private String uploadPath;
    private String uploadFileName;
    private Date uploadTime;

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 和课程表的关系
    // 一个班级只能上一门课
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 一个班级对应多个学生咨询
    private Set<StuAsk> stuAskSet = new HashSet<StuAsk>();

    public Set<StuAsk> getStuAskSet() {
        return stuAskSet;
    }

    public void setStuAskSet(Set<StuAsk> stuAskSet) {
        this.stuAskSet = stuAskSet;
    }

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 一个班级对应多个学生
    private Set<Student> studentSet = new HashSet<Student>();

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 班级
    public Classes(int classID, String name, Date beginTime, Date endTime, int totalCount, int upgradeCount, int changeCount, int runoffCount, String remark, String uploadPath, String uploadFileName, Date uploadTime) {
        this.classID = classID;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
        this.remark = remark;
        this.uploadPath = uploadPath;
        this.uploadFileName = uploadFileName;
        this.uploadTime = uploadTime;
    }

    public Classes() {
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public int getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public int getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(int runoffCount) {
        this.runoffCount = runoffCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classID=" + classID +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", totalCount=" + totalCount +
                ", upgradeCount=" + upgradeCount +
                ", changeCount=" + changeCount +
                ", runoffCount=" + runoffCount +
                ", remark='" + remark + '\'' +
                ", uploadPath='" + uploadPath + '\'' +
                ", uploadFileName='" + uploadFileName + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
