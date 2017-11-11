package com.lanou.hr_dep.web.action;

import com.lanou.hr_dep.domain.Department;
import com.lanou.hr_dep.service.DepartmentService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction {

    @Resource
    private DepartmentService departmentService;

    // 获取session
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();

    // 显示全部的部门信息
    public String listDepartment(){

        // 查询全部的部门信息放在session中
        List<Department> allDep = departmentService.findAllDep();

        session.setAttribute("allDep",allDep);

        return "showAllDep";
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

}
