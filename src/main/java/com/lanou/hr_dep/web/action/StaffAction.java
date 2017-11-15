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

    // 职员
    public String listStaff() {

        // 查询部门，用来二级联动
        List<Department> allDep = departmentService.findAllDep();
        // 把部门存进session
        sessionPut("allDep", allDep);

        // 所有职员
        List<Staff> allStaff = staffService.findAllStaff();

        // 将所有职员存进session
        sessionPut("allStaff", allStaff);

        return "showAllStaff";
    }

    // 添加
    public String addStaff() {

        System.out.println("页面获取： " + getModel());

//        staffService.addOrEditStaff(getModel());
        return "addStaff";
    }

    // 二级联动的添加职员（查询职务）
    public String findPost() {
        // 从页面获取的是Staff类型的参数
        List<Department> departments =
                departmentService.findIDByDep(getModel().getPost().getDepartment());

        // 在下拉列表中选择了"请选择"这一项，就传一个null回去
        if (departments.size() == 0){
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
