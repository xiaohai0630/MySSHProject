package com.lanou.hr_dep.service;

import com.lanou.hr_dep.domain.Staff;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface StaffService {

    // 显示全部职务
    List<Staff> findAllStaff();
}
