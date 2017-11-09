package com.lanou.plan_dep.domain;

import com.lanou.ask_dep.domain.StuAsk;
import com.lanou.teaching_dep.domain.Classes;

/**
 * Created by dllo on 17/9/21.
 */
public class Student {
    // 学生信息表

    // 主键studentID
    private int studentID;
    private String name;
    private String telephone;
    private String identity;
    private String qq;
    private String gender;
    private double mustTuition;
    private double actualTuition;
    private String email;
    private String school;
    private String education;
    private String professional;
    private String identityAddress;
    private String address;
    private String remark;
    private String homeTelephone;
    private String homeContact;
    private String status;

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 关系
    // 学员和班级：n～1
    private Classes classes;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 学员和咨询：1～1
    private StuAsk stuAsk;

    public StuAsk getStuAsk() {
        return stuAsk;
    }

    public void setStuAsk(StuAsk stuAsk) {
        this.stuAsk = stuAsk;
    }

    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    // 学生表
    public Student(int studentID, String name, String telephone, String identity, String qq, String gender, double mustTuition, double actualTuition, String email, String school, String education, String professional, String identityAddress, String address, String remark, String homeTelephone, String homeContact, String status) {
        this.studentID = studentID;
        this.name = name;
        this.telephone = telephone;
        this.identity = identity;
        this.qq = qq;
        this.gender = gender;
        this.mustTuition = mustTuition;
        this.actualTuition = actualTuition;
        this.email = email;
        this.school = school;
        this.education = education;
        this.professional = professional;
        this.identityAddress = identityAddress;
        this.address = address;
        this.remark = remark;
        this.homeTelephone = homeTelephone;
        this.homeContact = homeContact;
        this.status = status;
    }

    public Student() {
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getMustTuition() {
        return mustTuition;
    }

    public void setMustTuition(double mustTuition) {
        this.mustTuition = mustTuition;
    }

    public double getActualTuition() {
        return actualTuition;
    }

    public void setActualTuition(double actualTuition) {
        this.actualTuition = actualTuition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHomeTelephone() {
        return homeTelephone;
    }

    public void setHomeTelephone(String homeTelephone) {
        this.homeTelephone = homeTelephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getIdentityAddress() {
        return identityAddress;
    }

    public void setIdentityAddress(String identityAddress) {
        this.identityAddress = identityAddress;
    }

    public String getHomeContact() {
        return homeContact;
    }

    public void setHomeContact(String homeContact) {
        this.homeContact = homeContact;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", identity='" + identity + '\'' +
                ", qq='" + qq + '\'' +
                ", gender='" + gender + '\'' +
                ", mustTuition=" + mustTuition +
                ", actualTuition=" + actualTuition +
                ", email='" + email + '\'' +
                ", school='" + school + '\'' +
                ", education='" + education + '\'' +
                ", professional='" + professional + '\'' +
                ", identityAddress='" + identityAddress + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", homeTelephone='" + homeTelephone + '\'' +
                ", homeContact='" + homeContact + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
