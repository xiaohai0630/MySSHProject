package com.lanou.hr_dep.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/9/21.
 */
public class Post {
    /**
     * 职务表
     * 职务编号（主键postID）
     * 职务名称
     *
     * 关联关系：
     * 多个表对应一个部门（双向的，不用维护主外键）
     * 一个表对应多个员工
     */
    private int postID;
    private String postName;

    // 表之间关系
    // 职务和部门之间的关系：多对一
    // 用实体类来代替部门ID，直接用关联关系获取外键
    // 这样就不用自己设置了
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 一个职务对应多个员工
    private Set<Staff> staffSet = new HashSet<Staff>();

    public Set<Staff> getStaffSet() {
        return staffSet;
    }

    public void setStaffSet(Set<Staff> staffSet) {
        this.staffSet = staffSet;
    }

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 职务表本身的get、set
    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", postName='" + postName + '\'' +
                ", department=" + department +
                '}';
    }

}
