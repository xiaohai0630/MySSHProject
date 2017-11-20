package com.lanou.hr_dep.service;

import com.lanou.hr_dep.domain.Post;
import com.lanou.hr_dep.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface PostService {

    // 查询全部
    List<Post> findAllPost();

    // 查询对应部门的职务
    List<Post> findPostWithDep(Post post);

    // 根据部门id和职务名称查询
    List<Post> findPostWithDepIDAndPostName(Post post);

    // 添加或编辑
    void addOrEditPost(Post post);

    // 通过id查询职务
    Post findPostByID(Post post);
}
