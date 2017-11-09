package com.lanou.base;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by dllo on 17/11/9.
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

    private T t;

    public T getModel() {
        return null;
    }

    /**
     * 泛型：
     * 泛型也可以称之为类的参数
     * 参数的类型是某个类，而不是对象
     * 在一对尖括号中是一个泛型（这里怎么写，用的时候就怎么写）
     * <p>
     * 常用：
     * T：type
     * E：Element/Entity
     * K：key
     * V：value
     */

    /*
    public <E> E create(E entity){

    }

    public <E> List<E> create(Class<E> clazz){

    }
    */

}
