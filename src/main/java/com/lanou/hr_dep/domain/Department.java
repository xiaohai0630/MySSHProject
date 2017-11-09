package com.lanou.hr_dep.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/9/21.
 */
public class Department {
    /**
     * 部门表
     * 部门编号（主键depID）
     * 部门名称depName
     *
     * 关联关系：
     * 一个部门对应多个职务
     * 在部门里面写职务的Set集合
     */
    private int depID;
    private String depName;

    // 一个部门对应多个职务
    private Set<Post> postSet = new HashSet<Post>();

    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }

    // get、set方法
    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depID=" + depID +
                ", depName='" + depName + '\'' +
                '}';
    }

}
