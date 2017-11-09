package com.lanou.plan_dep.domain;

import java.util.Date;

/**
 * Created by dllo on 17/9/21.
 */
public class StuChange {

    private int stationID;
    private int studentID;
    private boolean flag;
    private int staffId;
    private Date createDate;
    private int beforeClassId;
    private int afterClassId;

    public StuChange(int stationID, int studentID, boolean flag, int staffId, Date createDate, int beforeClassId, int afterClassId) {
        this.stationID = stationID;
        this.studentID = studentID;
        this.flag = flag;
        this.staffId = staffId;
        this.createDate = createDate;
        this.beforeClassId = beforeClassId;
        this.afterClassId = afterClassId;
    }

    public StuChange() {
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getBeforeClassId() {
        return beforeClassId;
    }

    public void setBeforeClassId(int beforeClassId) {
        this.beforeClassId = beforeClassId;
    }

    public int getAfterClassId() {
        return afterClassId;
    }

    public void setAfterClassId(int afterClassId) {
        this.afterClassId = afterClassId;
    }

    @Override
    public String toString() {
        return "StuChange{" +
                "stationID=" + stationID +
                ", studentID=" + studentID +
                ", flag=" + flag +
                ", staffId=" + staffId +
                ", createDate=" + createDate +
                ", beforeClassId=" + beforeClassId +
                ", afterClassId=" + afterClassId +
                '}';
    }

}
