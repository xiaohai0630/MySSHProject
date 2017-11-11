package com.lanou.hr_dep.service.impl;

import com.lanou.hr_dep.dao.DepartmentDao;
import com.lanou.hr_dep.domain.Department;
import com.lanou.hr_dep.service.DepartmentService;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    // 查询全部的部门
    public List<Department> findAllDep() {
        return departmentDao.findAll();
    }

    // 添加或修改
    public void saveOrUpdate(Department department) {
        departmentDao.saveOrUpdate(department);
    }

    // 通过id查询部门名称
    public Department findDepByID(Department department) {
        return departmentDao.findById(department.getDepID());
    }

}
