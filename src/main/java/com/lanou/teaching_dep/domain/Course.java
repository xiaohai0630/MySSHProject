package com.lanou.teaching_dep.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/9/21.
 */
public class Course {
    /**
     * 课程表
     * 多个班级可以上同一个课程
     * 主键courseTypeID
     */

    private int courseTypeID;
    private double courseCost;
    private int total;
    private String courseName;
    private String remark;

    // 多个班级上同一个课程
    private Set<Classes> classes = new HashSet<Classes>();

    public Set<Classes> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classes> classes) {
        this.classes = classes;
    }

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public Course(int courseTypeID, double courseCost, int total, String courseName, String remark) {
        this.courseTypeID = courseTypeID;
        this.courseCost = courseCost;
        this.total = total;
        this.courseName = courseName;
        this.remark = remark;
    }

    public Course() {
    }

    public int getCourseTypeID() {
        return courseTypeID;
    }

    public void setCourseTypeID(int courseTypeID) {
        this.courseTypeID = courseTypeID;
    }

    public double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(double courseCost) {
        this.courseCost = courseCost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseTypeID=" + courseTypeID +
                ", courseCost=" + courseCost +
                ", total=" + total +
                ", courseName='" + courseName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

}
