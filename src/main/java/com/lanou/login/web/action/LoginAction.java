package com.lanou.login.web.action;

import com.lanou.base.BaseAction;
import com.lanou.hr_dep.domain.Staff;
import com.lanou.login.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<Staff> {
    /**
     * 员工登录：
     * 接收页面传递的参数Staff，和数据库中存的信息进行比较
     * 正确返回SUCCESS，并跳转页面
     * 错误返回ERROR，返回登录页面并提示错误
     */

    // 接收页面的数据
    private Staff staff = new Staff();

    public Staff getModel() {
        return staff;
    }

    // session
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();

    @Resource
    private LoginService loginService;

    // 登录
    public String login() {

        try {
            // 判断是否有这个员工
            List<Staff> login = loginService.loginByStaff(staff);

            if (login.size() > 0) {

                // 将数据库中查询到的员工信息存在session中，并且跳转主页面
                ActionContext.getContext().getSession().put("staffMsg", login.get(0));
                // 清楚错误信息
                session.removeAttribute("loginError");
                return SUCCESS;
            }

            session.setAttribute("loginError", "用户名或密码不正确");
            return ERROR;
        } catch (Exception e) {

            session.setAttribute("loginError", "用户名或密码不正确");
            return ERROR;
        }

    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

}
