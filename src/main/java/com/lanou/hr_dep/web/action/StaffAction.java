package com.lanou.hr_dep.web.action;

import com.lanou.base.BaseAction;
import com.lanou.hr_dep.domain.Staff;
import com.lanou.hr_dep.service.StaffService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {

    @Resource
    private StaffService staffService;

    // 获取session
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();

    public String listStaff(){

        // 同时查询部门和职务，用来二级联动的查询

        List<Staff> allStaff = staffService.findAllStaff();

        System.out.println(allStaff);
        // 全部的职员
        session.setAttribute("allStaff",allStaff);

        return "showAllStaff";
    }


    public StaffService getStaffService() {
        return staffService;
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

}
