package com.lanou.hr_dep.web.action;

import com.lanou.base.BaseAction;
import com.lanou.hr_dep.domain.Staff;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by dllo on 17/11/11.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
}
