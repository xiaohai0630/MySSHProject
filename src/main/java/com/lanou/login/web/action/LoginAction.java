package com.lanou.login.web.action;

import com.lanou.base.BaseAction;
import com.lanou.hr_dep.domain.Staff;
import com.lanou.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by dllo on 17/11/9.
 */
public class LoginAction extends BaseAction<Staff>{
    /**
     * 登录页面：
     */

    // 接收页面的数据
    private Staff staff;

    @Qualifier("loginService")
    @Autowired
    private LoginService loginService;

    // 登录
    public String login(){

        System.out.println(staff);

        return SUCCESS;
    }


    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

}
