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

}
