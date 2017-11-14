package com.lanou.hr_dep.service.impl;

import com.lanou.hr_dep.dao.StaffDao;
import com.lanou.hr_dep.domain.Staff;
import com.lanou.hr_dep.service.StaffService;

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

    // 编辑或添加职员
    public void addOrEditStaff(Staff staff) {
        staffDao.saveOrUpdate(staff);
    }

}
