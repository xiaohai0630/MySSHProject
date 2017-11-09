package com.lanou.plan_dep.domain;

import java.util.Date;

/**
 * Created by dllo on 17/9/21.
 */
public class StuLoose {
    /**
     * 学生流失情况信息表
     * 关系：
     * 一个表对应一个学生，1～1
     */

    private int runOffId;
    private String staffId;
    private Date createDate;
    private String isRefund;
    private double refundAmount;
    private String remark;

    public StuLoose(int runOffId, String staffId, Date createDate, String isRefund, double refundAmount, String remark) {
        this.runOffId = runOffId;
        this.staffId = staffId;
        this.createDate = createDate;
        this.isRefund = isRefund;
        this.refundAmount = refundAmount;
        this.remark = remark;
    }

    public StuLoose() {
    }

    public int getRunOffId() {
        return runOffId;
    }

    public void setRunOffId(int runOffId) {
        this.runOffId = runOffId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(String isRefund) {
        this.isRefund = isRefund;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "StuLoose{" +
                "runOffId=" + runOffId +
                ", staffId='" + staffId + '\'' +
                ", createDate=" + createDate +
                ", isRefund=" + isRefund +
                ", refundAmount=" + refundAmount +
                ", remark='" + remark + '\'' +
                '}';
    }
}
