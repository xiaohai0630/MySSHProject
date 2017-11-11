package com.lanou.hr_dep.web.action;

import com.lanou.base.BaseAction;
import com.lanou.hr_dep.domain.Post;
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

    @Resource
    private PostService postService;

    // 获取session
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();

    public String listPost() {

        List<Post> allPost = postService.findAllPost();
        session.setAttribute("allPost", allPost);

        return "showAllPost";
    }


    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

}
