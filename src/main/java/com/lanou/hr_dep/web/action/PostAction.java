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
public class PostAction extends BaseAction<Post, PostService> {

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

        // 如果postID等于空，说明点击的是添加，不需要显示原有的信息
        if (postID == null) {
            // 如果选中的是请选择，提示重新选择
            if (getModel().getDepartment().getDepID() == -1){
                session.setAttribute("wrongChoose","部门名称不能为请选择！");
                return "wrongChoose";
            }
            // 清除session中职务信息和选择错误信息
            session.removeAttribute("addOrEditPost");
            session.removeAttribute("wrongChoose");

            // 添加
            postService.addOrEditPost(getModel());

        } else {
            // 将这个职务的id赋值给post
            Post post = new Post();
            post.setPostID(Integer.valueOf(postID));

            // 清除request中的信息
            request.removeAttribute("addOrEditPost");

            // 找到这个id对应的职务（包含部门的信息）
            Post postByID = postService.findPostByID(post);

            // 把这个职务存在session中，用来在页面显示
            session.setAttribute("addOrEditPost", postByID);
            return "edit";
        }
        return "addOrEdit";
    }

    // 从添加或编辑页面返回，需要清除session中的信息，下次再进入的时候不会显示默认信息
    public String returnListPost() {
        session.removeAttribute("addOrEditPost");
        return "returnListPost";
    }

}
