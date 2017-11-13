package com.lanou.hr_dep.web.action;

import com.lanou.base.BaseAction;
import com.lanou.hr_dep.domain.Department;
import com.lanou.hr_dep.domain.Post;
import com.lanou.hr_dep.service.DepartmentService;
import com.lanou.hr_dep.service.PostService;
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
@Controller("postAction")
@Scope("prototype")
public class PostAction extends BaseAction<Post> {

    // 获取页面信息
    private Post post = new Post();

    public Post getModel() {
        return post;
    }

    // 获取下拉列表中部门的名称
    private String addOrEditPost_depName;

    public String getAddOrEditPost_depName() {
        return addOrEditPost_depName;
    }

    public void setAddOrEditPost_depName(String addOrEditPost_depName) {
        this.addOrEditPost_depName = addOrEditPost_depName;
    }

    @Resource
    private PostService postService;

    @Resource
    private DepartmentService departmentService;

    // 获取session
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();

    // 全部的职务信息
    public String listPost() {
        // 查询全部的部门，存在session中，在添加职务的时候，可以在下拉列表显示
        List<Department> allDep = departmentService.findAllDep();
        session.setAttribute("allDep", allDep);

        // 查询全部的职务信息
        List<Post> allPost = postService.findAllPost();
        session.setAttribute("allPost", allPost);

        return "showAllPost";
    }

    // 添加或编辑职务信息
    public String addOrEditPost() {

        // 判断是添加还是修改
        String postID = request.getParameter("addOrEditPost");

        if (postID == null) {
            // 添加
            Department department = new Department();
            department.setDepName(addOrEditPost_depName);

            // 查询部门id
            List<Department> departments = departmentService.findIDByDep(department);

            // 职务的完整信息
            post.setDepartment(departments.get(0));

            // 需要修改的职务的id存在这个session中
            if (session.getAttribute("addOrEditPost") != null){

                // 找职务的id
                Post edit = (Post) session.getAttribute("addOrEditPost");
                post.setPostID(edit.getPostID());

                // 清除session中职务信息
                session.removeAttribute("addOrEditPost");
            }
            // 添加
            postService.addOrEditPost(post);

        } else {
            // 修改
            Post post = new Post();
            post.setPostID(Integer.valueOf(postID));

            // 清除request中的信息
            request.removeAttribute("addOrEditPost");

            // 找到这个id对应的职务
            Post postByID = postService.findPostByID(post);

            // 把这个部门存在session中，用来在页面显示
            session.setAttribute("addOrEditPost", postByID);
            return "edit";
        }
        return "addOrEdit";
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

}
