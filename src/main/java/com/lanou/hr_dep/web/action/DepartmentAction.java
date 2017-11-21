package com.lanou.hr_dep.web.action;

import com.lanou.base.BaseAction;
import com.lanou.hr_dep.domain.Department;
import com.lanou.hr_dep.service.DepartmentService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

import static com.lanou.utils.MyConstant.DEPARTMENT_ADD_OR_EDIT_ERROR;
import static com.lanou.utils.MyConstant.DEPARTMENT_MSG;
import static com.lanou.utils.MyConstant.STAFF_CHANGE_LOGIN_PWD_ERROR;

/**
 * Created by dllo on 17/11/10.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department, DepartmentService> {
    @Resource
    private DepartmentService departmentService;

    // 显示全部的部门信息
    public String listDepartment() {
        // 查询全部的部门信息放在session中
        List<Department> allDep = departmentService.findAllDep();

        // 存放全部的部门信息，用来在页面上显示
        sessionPut("allDep", allDep);

        // 清除部门的相关错误信息
        sessionRemove(STAFF_CHANGE_LOGIN_PWD_ERROR);
        sessionRemove(DEPARTMENT_ADD_OR_EDIT_ERROR);
        sessionRemove(DEPARTMENT_MSG);

        return "showAllDep";
    }

    // 判断是添加还是修改，需要跳转不同的页面
    public String addOrEditDepartment() {

        // 判断是添加还是修改
        String depID = requestGet("addOrEditDep");

        if (depID == null) {
            // 部门名称为空或者重名都提示错误
            if (getModel().getDepName().equals("")) {
                sessionPut(DEPARTMENT_ADD_OR_EDIT_ERROR, "部门名称不能为空");
                return "wrongDept";
            }
            List<Department> allDep = departmentService.findAllDep();
            for (int i = 0; i < allDep.size(); i++) {

                if (allDep.get(i).getDepName().equals(getModel().getDepName())) {
                    sessionPut(DEPARTMENT_ADD_OR_EDIT_ERROR, "部门名称不能重复");
                    return "wrongDept";
                }

            }
            // 清除session中的部门信息
            sessionRemove(DEPARTMENT_MSG);
            // 保存或更新
            departmentService.saveOrUpdate(getModel());
        } else {
            // 部门名称不为空
            Department dep = new Department();
            dep.setDepID(Integer.valueOf(depID));

            // 清除request中的部门信息
            requestRemove("addOrEditDep");

            // 找到这个id对应的部门
            Department depByID = departmentService.findDepByID(dep);

            // 把这个部门存在session中，用来在页面上显示部门名称
            sessionPut(DEPARTMENT_MSG, depByID);
            return "edit";
        }
        return "addOrEdit";
    }

    // 从添加或修改部门页面返回部门列表
    public String returnListDept() {
        // 清除错误信息和修改时候显示的当前部门信息
        sessionRemove(DEPARTMENT_ADD_OR_EDIT_ERROR);
        sessionRemove(DEPARTMENT_MSG);
        return "returnListDept";
    }

}
