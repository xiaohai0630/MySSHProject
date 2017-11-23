package com.lanou.utils;

import com.lanou.hr_dep.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/22.
 */
public class PagerBean {

    private int totalSize;
    private List<Staff> staffs;

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

}
