package com.lanou.login.web.action;

import com.lanou.base.BaseAction;
import com.lanou.hr_dep.domain.Staff;
import com.lanou.hr_dep.service.StaffService;
import com.lanou.login.service.LoginService;
import com.lanou.utils.MD5Utils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.lanou.utils.MyConstant.*;

/**
 * Created by dllo on 17/11/9.
 */
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<Staff, StaffService> {
    /**
     * 员工登录：
     * 接收页面传递的Staff类型的参数，和数据库中存的信息进行比较
     * 正确返回SUCCESS，并跳转页面
     * 错误返回wrong，返回登录页面并提示错误
     * 出现异常的时候返回ERROR，跳转错误页面
     */
    // 验证－－用户名、密码
    private String loginName;
    private String loginPwd;

    // 修改密码，验证－－旧的用户名、新密码、确认密码
    private String oldPassword;
    private String newPassword;
    private String reNewPassword;

    // 退出登录的时候，需要清空session
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();

    @Resource
    private LoginService loginService;

    // 登录
    public String login() {

        try {
            /**
             * getModel()直接获取页面上的员工的信息
             * 判断是否有这个员工，集合大于0，有这个用户
             * MD5加密
             */
            if (getModel().getLoginPwd() != null && !getModel().getLoginPwd().equals("")) {
                String pwd = getModel().getLoginPwd();
                String md5 = MD5Utils.md5(pwd);
                getModel().setLoginPwd(md5);
            }
            // 查询职员
            List<Staff> login = loginService.loginByStaff(getModel());

            if (login.size() > 0) {
                // 将数据库中查询到的员工信息存在session中，并且跳转主页面
                sessionPut(NOWSTAFF, login.get(0));
                // 清除错误信息
                sessionRemove(STAFFLOGINERROR);
                return SUCCESS;
            }
            sessionPut(STAFFLOGINERROR, "用户名或密码不正确");
            return "wrong";
        } catch (Exception e) {
            // 出现异常的时候到error界面
            return ERROR;
        }

    }

    // 退出登录
    public String logout() {
        // 清空session
        session.invalidate();
        return "wrong";
    }

    // 修改密码
    public String staffEditPwd() {
        // 当前登录的员工
        Staff oldStaff = (Staff) sessionGet(NOWSTAFF);

        try {
            // MD5
            String oldPasswordMD5 = MD5Utils.md5(oldPassword);
            String newPasswordMD5 = MD5Utils.md5(newPassword);
            String reNewPasswordMD5 = MD5Utils.md5(reNewPassword);

            // 原始密码不一致
            if (!oldStaff.getLoginPwd().equals(oldPasswordMD5)) {
                sessionPut(STAFFCHANGELOGINPWDERROR, "原始密码不正确");
                return "editPwdError";
            }

            // 新密码和确认密码是否一致
            if (newPasswordMD5.equals(reNewPasswordMD5) && reNewPasswordMD5.equals(newPasswordMD5)) {

                // 新密码和原始密码相同
                if (oldPasswordMD5.equals(newPasswordMD5)) {
                    sessionPut(STAFFCHANGELOGINPWDERROR, "新密码和原密码相同");
                    return "editPwdError";
                }

                // 新的员工信息
                Staff changeStaff = oldStaff;
                changeStaff.setLoginPwd(newPasswordMD5);

                loginService.editPwd(changeStaff);
                // 清空session的信息，跳转登录页面
                session.invalidate();
                return "reLogin";
            }
            sessionPut(STAFFCHANGELOGINPWDERROR, "两次密码不一致");
            return "editPwdError";

        } catch (Exception e) {
            // 出现异常
            return ERROR;
        }

    }

    // 从修改密码页面返回主页面
    public String returnFrame() {
        // 清除错误信息
        sessionRemove(STAFFCHANGELOGINPWDERROR);
        return "returnFrame";
    }

    // 修改密码
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

}
