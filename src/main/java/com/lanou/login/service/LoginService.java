package com.lanou.login.service;

import com.lanou.hr_dep.domain.Staff;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface LoginService {

    // 登录
    List<Staff> loginByStaff(Staff staff);

    // 修改密码
    void editPwd(Staff staff);
}
