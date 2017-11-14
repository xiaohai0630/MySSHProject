package com.lanou.hr_dep.web.action;

import com.lanou.base.BaseAction;
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
public class DepartmentAction extends BaseAction<Department,DepartmentService> {

    // 从页面获取的数据
    private Department department = new Department();

    public Department getModel() {
        return department;
    }

    @Resource
    private DepartmentService departmentService;

    // 获取session
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();

    // 显示全部的部门信息
    public String listDepartment() {

        // 查询全部的部门信息放在session中
        List<Department> allDep = departmentService.findAllDep();

        // 存放全部的部门信息，用来在页面上显示
        session.setAttribute("allDep", allDep);

        return "showAllDep";
    }

    // 判断是添加还是修改，需要跳转不同的页面
    public String addOrEditDepartment() {

        // 判断是添加还是修改
        String depID = request.getParameter("addOrEditDep");

        if (depID == null) {
            // 部门名称为空
            if (session.getAttribute("addOrEditDep") != null) {
                // 找到session中的部门信息，把它的id给页面上获取的department
                Department edit = (Department) session.getAttribute("addOrEditDep");
                department.setDepID(edit.getDepID());

                // 清除session中的部门信息
                session.removeAttribute("addOrEditDep");
                departmentService.saveOrUpdate(department);
            }
            // 把页面上获取的内容添加进数据库
            departmentService.saveOrUpdate(department);
        } else {
            // 部门名称不为空
            Department dep = new Department();
            dep.setDepID(Integer.valueOf(depID));

            // 清除request中的部门信息
            request.removeAttribute("addOrEditDep");

            // 找到这个id对应的部门
            Department depByID = departmentService.findDepByID(dep);

            // 把这个部门存在session中，用来在页面上显示部门名称
            session.setAttribute("addOrEditDep", depByID);
            return "edit";
        }
        return "addOrEdit";
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
