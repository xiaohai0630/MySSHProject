package com.lanou.hr_dep.dao.impl;

import com.lanou.base.dao.impl.BaseDaoImpl;
import com.lanou.hr_dep.dao.PostDao;
import com.lanou.hr_dep.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {

    // 根据职务的名字查询
    public List<Post> findAll(Post post){

        String sql = "from Post where department=?";
        return (List<Post>) this.getHibernateTemplate().find(sql,post);
    }
}
