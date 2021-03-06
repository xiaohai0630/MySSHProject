package com.lanou.hr_dep.web.action;

import com.lanou.base.BaseAction;
import com.lanou.hr_dep.domain.Department;
import com.lanou.hr_dep.domain.Post;
import com.lanou.hr_dep.service.DepartmentService;
import com.lanou.hr_dep.service.PostService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import static com.lanou.utils.MyConstant.*;

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

    // 全部的职务信息
    public String listPost() {
        // 查询全部的部门，存在session中，在添加职务的时候，可以在下拉列表显示
        List<Department> allDep = departmentService.findAllDep();
        sessionPut("allDep", allDep);

        // 查询全部的职务信息
        List<Post> allPost = postService.findAllPost();
        sessionPut("allPost", allPost);

        // 清除添加职务页面的错误信息
        sessionRemove(POST_ADD_OR_EDIT_ERROR);
        sessionRemove(STAFF_CHANGE_LOGIN_PWD_ERROR);
        sessionRemove(POST_MSG);
        sessionRemove(STAFF_MSG);

        return "showAllPost";
    }

    // 添加或编辑职务信息
    public String addOrEditPost() {

        // 判断是添加还是修改
        String postID = requestGet("addOrEditPost");

        // 如果postID等于空，说明点击的是添加，不需要显示原有的信息
        if (postID == null) {
            // 如果选中的是请选择，提示重新选择
            if (getModel().getDepartment().getDepID() == -1) {
                sessionPut(POST_ADD_OR_EDIT_ERROR, "部门名称不能为请选择！");
                return "wrongChoose";
            }

            // 如果职务名称为空或重名，都需要提示错误
            if (getModel().getPostName().equals("")) {
                sessionPut(POST_ADD_OR_EDIT_ERROR, "职务名称不能为空");
                return "wrongChoose";
            }

            // 根据部门id和职务名称查询
            List<Post> posts = postService.findPostWithDepIDAndPostName(getModel());

            if (posts.size() > 0) {
                sessionPut(POST_ADD_OR_EDIT_ERROR, "职务名称不能相同");
                return "wrongChoose";
            }

            // 清除session中职务信息和选择错误信息
            sessionRemove(POST_MSG);
            sessionRemove(POST_ADD_OR_EDIT_ERROR);

            // 添加或修改
            postService.addOrEditPost(getModel());

        } else {
            // 将这个职务的id赋值给post
            Post post = new Post();
            post.setPostID(Integer.valueOf(postID));

            // 清除request中的信息
            requestRemove("addOrEditPost");

            // 找到这个id对应的职务（包含部门的信息）
            Post postByID = postService.findPostByID(post);

            // 把这个职务存在session中，用来在页面显示
            sessionPut(POST_MSG, postByID);
            return "edit";
        }
        return "addOrEdit";
    }

    // 从添加或编辑页面返回职务列表
    public String returnListPost() {
        // 编辑时候的职务的信息
        sessionRemove(POST_MSG);
        sessionRemove(POST_ADD_OR_EDIT_ERROR);

        return "returnListPost";
    }

}
