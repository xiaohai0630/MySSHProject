package com.lanou.login.web.action;

import com.lanou.base.BaseAction;
import com.lanou.hr_dep.domain.Staff;
import com.lanou.login.service.LoginService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/9.
 */
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<Staff>{
    /**
     * 员工登录：
     * 接收页面传递的参数Staff，和数据库中存的信息进行比较
     * 正确返回SUCCESS，并跳转页面
     * 错误返回ERROR，返回登录页面并提示错误
     */

    // 接收页面的数据
    private Staff staff = new Staff();

    public Staff getModel(){
        return staff;
    }


    @Resource
    private LoginService loginService;

    // 登录
    public String login(){

        System.out.println(staff);
        Staff login = loginService.loginByStaff(staff);

        if (login == null){
            return ERROR;
        }

        return SUCCESS;
    }


    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

}
