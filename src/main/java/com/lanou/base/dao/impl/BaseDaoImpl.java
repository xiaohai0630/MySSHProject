package com.lanou.base.dao.impl;

import com.lanou.base.dao.BaseDao;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class<T> beanClass;

    public BaseDaoImpl() {
        // this ,在运行时表示的【当前运行类】。在编译时表示就是【当前类】
        // 1 获得当前运行类的父类，父类具有泛型信息，
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 2 获得实际参数
        beanClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }


    public void save(T t) {
        getSessionFactory().getCurrentSession().setFlushMode(FlushMode.COMMIT);
        this.getHibernateTemplate().save(t);
    }


    public void update(T t) {
        getSessionFactory().getCurrentSession().setFlushMode(FlushMode.COMMIT);
        this.getHibernateTemplate().update(t);
    }

    public void saveOrUpdate(T t) {
        getSessionFactory().getCurrentSession().setFlushMode(FlushMode.COMMIT);
        this.getHibernateTemplate().saveOrUpdate(t);
    }


    public void delete(T t) {
        getSessionFactory().getCurrentSession().setFlushMode(FlushMode.COMMIT);
        this.getHibernateTemplate().delete(t);
    }


    public T findById(Serializable id) {
        getSessionFactory().getCurrentSession().setFlushMode(FlushMode.COMMIT);
        return this.getHibernateTemplate().get(beanClass, id);
    }


    public List<T> findAll() {
        // class.getName() 获得类的全限定类名，例如：java.lang.String
        return (List<T>) this.getHibernateTemplate().find("from " + beanClass.getName());
    }


    public List<T> findAll(String condition, Object... params) {
        String hql = "from " + beanClass.getName() + " where 1=1 " + condition;
        return (List<T>) this.getHibernateTemplate().find(hql, params);
    }

    public int getTotalRecord(String condition, Object[] params) {
        //1 创建Query对象
        Query queryObject = this.currentSession().createQuery
                ("select count(u) from " + beanClass.getName() + " u where 1=1 " + condition);

        //2参数封装
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                queryObject.setParameter(i, params[i]);
            }
        }
        Number number = (Number) queryObject.uniqueResult();

        return number.intValue();
    }

    public List findByPage(final String hql, final Object[] values,
                           final int offset, final int pageSize) {

        //通过一个HibernateCallback对象来执行查询

        List list = getHibernateTemplate().execute(new HibernateCallback<List>() {

            public List doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);//为hql语句传入参数
                for (int i = 0; i < values.length; i++) {
                    query.setParameter(i, values[i]);
                }
                List result = query.setFirstResult(offset).setMaxResults(pageSize).list();
                return result;
            }
            //实现HibernateCallback接口必须实现的方法
        });

        return list;

    }



    public int getTotalRecord() {
        List<Long> allData =
                (List<Long>) this.getHibernateTemplate().find
                        ("select count(u) from " + beanClass.getName() + " u");
        return allData.get(0).intValue();
    }

}
