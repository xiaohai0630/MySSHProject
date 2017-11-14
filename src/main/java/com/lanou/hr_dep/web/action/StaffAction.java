package com.lanou.hr_dep.web.action;

import com.lanou.base.BaseAction;
import com.lanou.hr_dep.domain.Department;
import com.lanou.hr_dep.domain.Post;
import com.lanou.hr_dep.domain.Staff;
import com.lanou.hr_dep.service.DepartmentService;
import com.lanou.hr_dep.service.PostService;
import com.lanou.hr_dep.service.StaffService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff,StaffService> {
    // 全局变量
    private List<Post> postList;

    // 部门－－二级联动，从页面获取的部门名称
    private String findPostWithDepName;
    private List<Department> departmentList;

    public String getFindPostWithDepName() {
        return findPostWithDepName;
    }

    public void setFindPostWithDepName(String findPostWithDepName) {
        this.findPostWithDepName = findPostWithDepName;
    }

    @Resource
    private StaffService staffService;

    @Resource
    private PostService postService;

    @Resource
    private DepartmentService departmentService;

    // 获取session
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();

    // 职员
    public String listStaff() {

        // 查询部门，用来二级联动
        List<Department> allDep = departmentService.findAllDep();
        // 把部门存进session
        session.setAttribute("allDep", allDep);

        // 所有职员
        List<Staff> allStaff = staffService.findAllStaff();

        // 将所有职员存进session
        session.setAttribute("allStaff", allStaff);

        return "showAllStaff";
    }

    // 添加
    public String addStaff() {

        System.out.println("页面获取： " + getModel());
        return "addStaff";
    }

    // 二级联动的添加职员（查询职务）
    public String findPost() {
        // 获取职务信息－－部门的名称
        Department department = new Department();
        department.setDepName(findPostWithDepName);
        // 用页面获取的部门的名称来查询这个部门
        List<Department> departments = departmentService.findIDByDep(department);
        // 把查询到的部门添加到post中
        Post post = new Post();
        post.setDepartment(departments.get(0));

        // 根据部门查询到的职务（全局变量？）
        postList = postService.findPostWithDep(post);

        return SUCCESS;
    }

    // 添加职员页面的二级联动
    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }


    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

}
