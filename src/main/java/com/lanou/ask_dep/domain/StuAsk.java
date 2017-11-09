package com.lanou.ask_dep.domain;

import com.lanou.human_dep.domain.Staff;
import com.lanou.plan_dep.domain.Student;
import com.lanou.teaching_dep.domain.Classes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/9/21.
 */
public class StuAsk {
    // 一个咨询表有多个跟踪表，1～n，单向一对多，删除咨询表，就删除级联的跟踪表
    // 一个咨询表有一个营销人员，1～1
    // 一个咨询表有一个班级，1～1

    // 主键referID
    private int referID;
    private String name;
    private String telephone;
    private String qq;
    private Date createDate;
    private String intentionLevel;
    private String source;
    private boolean status;
    private String remark;

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 一个咨询表有多个跟踪表，1～n
    private Set<StuFollow> stuFollowSet = new HashSet<>();

    public Set<StuFollow> getStuFollowSet() {
        return stuFollowSet;
    }

    public void setStuFollowSet(Set<StuFollow> stuFollowSet) {
        this.stuFollowSet = stuFollowSet;
    }

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 一个咨询表只能有一个班级（classID）
    // 多对一，多个咨询表可以对应一个班级
    private Classes classes;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 一个咨询表只能有一个营销人员（员工staffID）
    // 双向1～1，save－update
    private Staff staff;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 一个学生一个咨询表
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 咨询表
    public StuAsk(int referID, String name, String telephone, String qq, Date createDate, String intentionLevel, String source, boolean status, String remark) {
        this.referID = referID;
        this.name = name;
        this.telephone = telephone;
        this.qq = qq;
        this.createDate = createDate;
        this.intentionLevel = intentionLevel;
        this.source = source;
        this.status = status;
        this.remark = remark;
    }

    public StuAsk() {
    }

    public int getReferID() {
        return referID;
    }

    public void setReferID(int referID) {
        this.referID = referID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIntentionLevel() {
        return intentionLevel;
    }

    public void setIntentionLevel(String intentionLevel) {
        this.intentionLevel = intentionLevel;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "StuAsk{" +
                "referID=" + referID +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", qq='" + qq + '\'' +
                ", createDate=" + createDate +
                ", intentionLevel='" + intentionLevel + '\'' +
                ", source='" + source + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';

    }

}
