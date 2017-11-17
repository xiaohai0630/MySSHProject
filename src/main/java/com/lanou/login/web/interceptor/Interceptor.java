package com.lanou.login.web.interceptor;

import com.lanou.hr_dep.domain.Staff;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by dllo on 17/11/10.
 */
public class Interceptor extends MethodFilterInterceptor {
    // 拦截器？
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        Staff staff = (Staff) session.getAttribute("staffMsg");

        System.out.println(staff);

        // 如果没有登录，跳转到登录界面
        if (staff == null){
            return "interceptors";
        }

        return actionInvocation.invoke();
    }

}
