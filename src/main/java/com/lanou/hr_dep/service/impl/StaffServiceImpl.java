package com.lanou.hr_dep.service.impl;

import com.lanou.hr_dep.dao.StaffDao;
import com.lanou.hr_dep.domain.Post;
import com.lanou.hr_dep.domain.Staff;
import com.lanou.hr_dep.service.StaffService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    // 查询全部
    public List<Staff> findAllStaff() {
        return staffDao.findAll();
    }

    // 通过id查询某一个职员
    public List<Staff> findStaffByID(int staffID) {
        return staffDao.findAll("and staffID=?", staffID);
    }

    // 高级查询
    // 三个条件都有（部门相当于没有）
    public List<Staff> findStaffWithMsgAll(Staff staff) {

        return staffDao.findAll("and staffName like ? and postID=?",
                "%" + staff.getStaffName() + "%", staff.getPost().getPostID());
    }

    // 根据部门名称和姓名查询
    public List<Staff> findStaffWithMsgDepAndName(List<Post> posts, String name) {

        // 用来返回的职员的集合
        List<Staff> returnStaff = new ArrayList<Staff>();

        for (int i = 0; i < posts.size(); i++) {

            List<Staff> all = staffDao.findAll("and PostID=? and staffName like ?",
                    posts.get(i).getPostID(), "%" + name + "%");

            for (int j = 0; j < all.size(); j++) {
                returnStaff.add(j, all.get(j));
            }

        }
        return returnStaff;
    }

    // 根据职务查询（需要选择部门，但是查询条件中不需要部门的信息）
    public List<Staff> findStaffWithMsgPostID(Staff staff) {
        return staffDao.findAll("and PostID=?", staff.getPost().getPostID());
    }

    // 只是根据部门查询
    public List<Staff> findStaffWithMsgDep(List<Post> posts) {
        // 用来返回的职员的集合
        List<Staff> returnStaff = new ArrayList<Staff>();

        // 用集合查询
        for (int i = 0; i < posts.size(); i++) {

            List<Staff> all = staffDao.findAll("and PostID=?", posts.get(i).getPostID());
            for (int j = 0; j < all.size(); j++) {
                returnStaff.add(j, all.get(j));
            }

        }
        return returnStaff;
    }

    // 只根据员工姓名查询
    public List<Staff> findStaffWithMsgName(String staffName) {
        return staffDao.findAll("and staffName like ?", "%" + staffName + "%");
    }

    // 编辑或添加职员
    public void addOrEditStaff(Staff staff) {
        staffDao.saveOrUpdate(staff);
    }

}
