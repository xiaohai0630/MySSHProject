package com.lanou.login.service.impl;

import com.lanou.hr_dep.domain.Staff;
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

    // 登录的时候判断员工是否存在
    public Staff loginByStaff(Staff staff) {

        List<Staff> staffs = loginDao.findAll("and loginName=? and loginPwd=?",
                staff.getLoginName(), staff.getLoginPwd());

        return staffs.get(0);
    }

}
