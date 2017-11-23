package com.lanou.hr_dep.web.action;

import com.lanou.base.BaseAction;
import com.lanou.hr_dep.domain.Department;
import com.lanou.hr_dep.domain.Post;
import com.lanou.hr_dep.domain.Staff;
import com.lanou.hr_dep.service.DepartmentService;
import com.lanou.hr_dep.service.PostService;
import com.lanou.hr_dep.service.StaffService;
import com.lanou.utils.MD5Utils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import static com.lanou.utils.MyConstant.*;

/**
 * Created by dllo on 17/11/11.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff, StaffService> {
    // 二级联动时查询职务集合
    private List<Post> postList;

    // 用来存放高级查询的结果
    private List<Staff> returnStaffs;

    @Resource
    private StaffService staffService;

    @Resource
    private PostService postService;

    @Resource
    private DepartmentService departmentService;

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

        // 清除session中的错误信息提示
        sessionRemove(STAFF_CHANGE_LOGIN_PWD_ERROR);
        sessionRemove(STAFF_ADD_OR_EDIT_ERROR);
        sessionRemove(POST_MSG);
        sessionRemove(STAFF_MSG);

        return "showAllStaff";
    }

    // 添加职员
    public String addStaff() {

        // MD5加密
        String pwd = getModel().getLoginPwd();
        String md5 = MD5Utils.md5(pwd);
        getModel().setLoginPwd(md5);
        // 判断部门名称和职务名称
        if (getModel().getPost().getDepartment().getDepID() == -1) {
            sessionPut(STAFF_ADD_OR_EDIT_ERROR, "部门名称不能为请选择");
            return "addStaffError";
        }
        if (getModel().getPost().getPostID() == -1) {
            sessionPut(STAFF_ADD_OR_EDIT_ERROR, "职务名称不能为请选择");
            return "addStaffError";
        }
        // 符合条件就可以添加，添加之前清除错误信息
        sessionRemove(STAFF_ADD_OR_EDIT_ERROR);
        staffService.addOrEditStaff(getModel());
        return "addOrEditStaff";
    }

    // 编辑职员
    public String editStaff() {
        // 判断部门名称和职务名称
        if (getModel().getPost().getDepartment().getDepID() == -1) {
            sessionPut(STAFF_ADD_OR_EDIT_ERROR, "部门名称不能为请选择");
            return "editStaffError";
        }
        if (getModel().getPost().getPostID() == -1) {
            sessionPut(STAFF_ADD_OR_EDIT_ERROR, "职务名称不能为请选择");
            return "editStaffError";
        }
        // MD5加密
        String pwd = getModel().getLoginPwd();
        String md5 = MD5Utils.md5(pwd);
        getModel().setLoginPwd(md5);

        // 错误信息
        sessionRemove(STAFF_ADD_OR_EDIT_ERROR);
        staffService.addOrEditStaff(getModel());
        return "addOrEditStaff";
    }

    // 编辑员工－－显示员工信息
    public String editStaffList() {

        // request中的staff
        String editStaff = requestGet("editStaff");
        // 职员（一个职员）
        List<Staff> staffByID = staffService.findStaffByID(Integer.valueOf(editStaff));

        // 找他所在的部门的所有职务
        List<Post> postWithDep = postService.findPostWithDep(staffByID.get(0).getPost());

        // 存职务和职员信息
        sessionPut("editStaffPost", postWithDep);
        sessionPut(STAFF_MSG, staffByID.get(0));

        return "editStaffList";
    }

    // 点击左侧的列表：从添加或修改职员页面返回职员列表
    public String returnListStaff() {

        // 清除session中的信息
        sessionRemove(STAFF_ADD_OR_EDIT_ERROR);
        sessionRemove(STAFF_MSG);

        return "returnListStaff";
    }

    // 高级查询
    public String findStaffWithMsg() {

        // 根据不同情况调用不同的方法
        Staff staffMsg = getModel();

        // 选择了某个部门
        if (staffMsg.getPost().getDepartment().getDepID() != -1) {

            // 如果选择查询条件中有部门
            if (staffMsg.getPost().getPostID() != -1) {

                // 既有部门又有职务
                if (staffMsg.getStaffName() != null && !staffMsg.getStaffName().equals("")) {
                    // 三个条件全都有
                    returnStaffs = staffService.findStaffWithMsgAll(getModel());
                    return "findStaffWithMsg";
                }
                // 只有部门和职务
                returnStaffs = staffService.findStaffWithMsgPostID(getModel());
                return "findStaffWithMsg";
            } else {
                // 选择了部门，但是没有选择职务
                if (staffMsg.getStaffName() != null && !staffMsg.getStaffName().equals("")) {
                    // 根据部门和名字查询
                    returnStaffs =
                            staffService.findStaffWithMsgDepAndName(
                                    getModel().getPost().getDepartment().getDepID(), getModel().getStaffName());

                    return "findStaffWithMsg";
                } else {
                    // 只用部门查询－－需要先查询职务的id（用部门的id查询下属的职务）
                    List<Post> postWithDep = postService.findPostWithDep(getModel().getPost());

                    // 根据部门查询职员
                    returnStaffs = staffService.findStaffWithMsgDep(postWithDep);

                    return "findStaffWithMsg";
                }

            }

        } else {
            // 没选择部门
            if (staffMsg.getStaffName() != null && !staffMsg.getStaffName().equals("")) {
                // 只用姓名查询
                returnStaffs = staffService.findStaffWithMsgName(getModel().getStaffName());
                return "findStaffWithMsg";
            } else {
                // 三个条件都没有，相当于查询全部
                returnStaffs = staffService.findAllStaff();
                return "findStaffWithMsg";
            }

        }

    }

    // 二级联动的添加职员（查询职务）
    public String findPost() {

        // 在下拉列表中选择了"请选择"这一项，就传一个null回去
        if (getModel().getPost().getDepartment().getDepID() == 0) {
            postList = null;
            return SUCCESS;
        }

        // 把查询到的部门添加到post中
        Post post = new Post();
        post.setDepartment(getModel().getPost().getDepartment());

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

    // 高级查询
    public List<Staff> getReturnStaffs() {
        return returnStaffs;
    }

    public void setReturnStaffs(List<Staff> returnStaffs) {
        this.returnStaffs = returnStaffs;
    }

}
