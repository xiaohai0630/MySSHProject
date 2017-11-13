package com.lanou.hr_dep.service;

import com.lanou.hr_dep.domain.Department;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface DepartmentService {

    // 显示全部的部门
    List<Department> findAllDep();

    // 添加或修改
    void saveOrUpdate(Department department);

    // 通过id查询部门名称
    Department findDepByID(Department department);

    // 通过名字查询部门id
    List<Department> findIDByDep(Department department);
}
