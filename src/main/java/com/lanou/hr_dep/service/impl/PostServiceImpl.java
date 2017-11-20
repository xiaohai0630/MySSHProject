package com.lanou.hr_dep.service.impl;

import com.lanou.hr_dep.dao.PostDao;
import com.lanou.hr_dep.domain.Post;
import com.lanou.hr_dep.service.PostService;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class PostServiceImpl implements PostService {

    public PostDao postDao;

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    // 查询全部
    public List<Post> findAllPost() {
        return postDao.findAll();
    }

    // 根据部门查询职务
    public List<Post> findPostWithDep(Post post) {
        return postDao.findAll("and depID=?", post.getDepartment().getDepID());
    }

    // 通过部门id和职务名称查询
    public List<Post> findPostWithDepIDAndPostName(Post post) {
        return postDao.findAll("and depID=? and postName=?", post.getDepartment().getDepID(), post.getPostName());
    }

    // 添加或编辑
    public void addOrEditPost(Post post) {
        postDao.saveOrUpdate(post);
    }

    // 通过id查询职务
    public Post findPostByID(Post post) {
        return postDao.findById(post.getPostID());
    }

}
