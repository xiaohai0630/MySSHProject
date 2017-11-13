package com.lanou.hr_dep.dao.impl;

import com.lanou.base.dao.impl.BaseDaoImpl;
import com.lanou.hr_dep.dao.DepartmentDao;
import com.lanou.hr_dep.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

    public List<Department> findAll(Department department){

        String sql = "from Department where depName=?";
        return (List<Department>) this.getHibernateTemplate().find(sql,department);
    }

}
