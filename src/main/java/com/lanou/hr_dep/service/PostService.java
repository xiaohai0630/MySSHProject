package com.lanou.hr_dep.service;

import com.lanou.hr_dep.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface PostService {

    // 查询全部
    List<Post> findAllPost();

    // 添加或编辑
    void addOrEditPost(Post post);

    // 通过id查询职务
    Post findPostByID(Post post);
}
