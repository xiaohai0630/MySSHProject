package com.lanou.hr_dep.service;

import com.lanou.hr_dep.domain.Staff;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface StaffService {

    // 显示全部职员
    List<Staff> findAllStaff();

    List<Staff> findStaffByID(int staffID);

    // 编辑或添加职员
    void addOrEditStaff(Staff staff);
}
