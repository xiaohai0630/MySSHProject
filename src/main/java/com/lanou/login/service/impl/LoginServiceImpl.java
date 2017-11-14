package com.lanou.login.service.impl;

import com.lanou.hr_dep.dao.StaffDao;
import com.lanou.hr_dep.domain.Staff;
import com.lanou.hr_dep.service.StaffService;
import com.lanou.login.dao.LoginDao;
import com.lanou.login.service.LoginService;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao;

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    // 登录的时候判断员工是否存在－－登录名和密码能对应上的
    public List<Staff> loginByStaff(Staff staff) {

        List<Staff> staffs = loginDao.findAll("and loginName=? and loginPwd=?",
                staff.getLoginName(), staff.getLoginPwd());

        return staffs;
    }

    // 修改密码
    public void editPwd(Staff staff) {
        loginDao.saveOrUpdate(staff);
    }

}
