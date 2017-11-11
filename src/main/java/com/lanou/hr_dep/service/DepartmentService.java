package com.lanou.hr_dep.service;

import com.lanou.hr_dep.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface DepartmentService {

    // 显示全部的部门
    List<Department> findAllDep();

}
