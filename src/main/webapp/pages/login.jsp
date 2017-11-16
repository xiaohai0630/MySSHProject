<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
    <STYLE>
        .cla1 {
            FONT-SIZE: 12px;
            COLOR: #4b4b4b;
            LINE-HEIGHT: 18px;
            TEXT-DECORATION: none
        }

        .login_msg {
            font-family: serif;
        }

        .login_msg .msg {
            background-color: #acf;
        }

        .login_msg .btn {
            background-color: #9be;
            width: 73px;
            font-size: 18px;
            font-family: 微软雅黑;
        }
    </STYLE>

    <TITLE></TITLE>
    <script type="text/javascript">
        if (self != top) {
            top.location = self.location;
        }
    </script>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <LINK href="${pageContext.request.contextPath}/css/style.css" type=text/css rel=stylesheet>
    <META content="MSHTML 6.00.2600.0" name=GENERATOR>

</HEAD>

<body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"
      background="${pageContext.request.contextPath}/images/rightbg.jpg">

<%--BODY中的background属性：
    background="${pageContext.request.contextPath}/images/rightbg.jpg"
    去掉中间的EL表达式，这样就可以显示页面的样式了--%>

<div ALIGN="center">
    <table border="0" width="1140px" cellspacing="0" cellpadding="0" id="table1">
        <tr>
            <td height="193"></td>

        </tr>
        <tr align="center">

            <td class="login_msg" width="400">
                <form action="loginAction_login.action" method="post">

                    <font size="6" color="#ffffff">
                        欢迎使用CRM系统
                    </font>

                    <br/>
                    <br/>

                    <font color="#ff0000">
                        ${sessionScope.loginError}
                    </font>

                    <br/>
                    用户名：<input type="text" name="loginName" class="msg" value="aa"/><br/><br/>
                    密&nbsp;码：<input type="password" name="loginPwd" class="msg" value="222"/><br/><br/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit" class="btn" value="登录"/>

                </form>

            </td>

        </tr>

    </table>

    <%--验证器的验证--%>
    <s:fielderror fieldName="staff.loginName"></s:fielderror><br/>

    <script type="text/javascript">
        /* s标签中直接编写JavaScript代码时，不支持el表达式，只能提供单独的函数
         function registerUrl(){
         document.location='${pageContext.request.contextPath}/uiAction_staff_register';
         }
         */
    </script>
</div>

</body>

</HTML>
