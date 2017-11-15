package com.lanou.hr_dep.service;

import com.lanou.hr_dep.domain.Post;
import com.lanou.hr_dep.domain.Staff;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface StaffService {

    // 显示全部职员
    List<Staff> findAllStaff();

    // 通过员工id查询员工
    List<Staff> findStaffByID(int staffID);

    // 高级查询
    // 三个条件都有
    List<Staff> findStaffWithMsgAll(Staff staff);

    // 根据职务查询
    List<Staff> findStaffWithMsgPostID(Staff staff);

    // 只是根据部门查询
    List<Staff> findStaffWithMsgDep(List<Post> posts);

    // 编辑或添加职员
    void addOrEditStaff(Staff staff);
}
