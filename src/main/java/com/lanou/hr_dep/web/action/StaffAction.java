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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff, StaffService> {
    // 验证用
    private Staff staff;

    // 全局变量
    private List<Post> postList;

    @Resource
    private StaffService staffService;

    @Resource
    private PostService postService;

    @Resource
    private DepartmentService departmentService;

    // request
    HttpServletRequest request = ServletActionContext.getRequest();

    // 显示全部的职员
    public String listStaff() {

        // 查询部门，用来二级联动
        List<Department> allDep = departmentService.findAllDep();
        // 把部门存进session
        sessionPut("allDep", allDep);

        // 所有职员
        List<Staff> allStaff = staffService.findAllStaff();

        // 将所有职员存进session
        sessionPut("allStaff", allStaff);

        // 清除session中的信息
        sessionRemove("editStaffPost");
        sessionRemove("editStaff");

        return "showAllStaff";
    }

    // 添加或编辑职员
    public String addOrEditStaff() {

        System.out.println("页面获取： " + getModel());

        staffService.addOrEditStaff(getModel());
        return "addOrEditStaff";
    }

    // 编辑员工－－显示员工信息
    public String editStaff(){

        // request中的staff
        String editStaff = request.getParameter("editStaff");
        // 职员（一个职员）
        List<Staff> staffByID = staffService.findStaffByID(Integer.valueOf(editStaff));

        // 找他所在的部门的所有职务
        List<Post> postWithDep = postService.findPostWithDep(staffByID.get(0).getPost());

        // 存职务和职员信息
        sessionPut("editStaffPost",postWithDep);
        sessionPut("editStaff",staffByID.get(0));

        return "editStaff";
    }

    // 返回职员列表
    public String returnListStaff(){

        // 清除session中的信息
        sessionRemove("editStaffPost");
        sessionRemove("editStaff");

        return "returnListStaff";
    }

    // 二级联动的添加职员（查询职务）
    public String findPost() {
        // 从页面获取的是Staff类型的参数
        List<Department> departments =
                departmentService.findIDByDep(getModel().getPost().getDepartment());

        // 在下拉列表中选择了"请选择"这一项，就传一个null回去
        if (departments.size() == 0) {
            postList = null;
            return SUCCESS;
        }

        // 把查询到的部门添加到post中
        Post post = new Post();
        post.setDepartment(departments.get(0));

        // 根据部门查询到的职务
        postList = postService.findPostWithDep(post);

        return SUCCESS;
    }

    // 二级联动（职员列表和添加职员列表公用一个）
    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

}
