<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="/js/Calendar.js"></script>

    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="44%" align="left">[员工管理]</td>

        <td width="52%" align="right">
            <!-- 提交表单 -->
            <a href="javascript:void(0)" onclick="document.forms[0].submit()">
                <img src="/images/button/save.gif"/>
            </a>
            <!-- 执行js，进行返回 -->
            <a href="javascript:void(0)" onclick="window.history.go(-1)"><img
                    src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<form action="staffAction_addStaff.action" method="post">
    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>登录名：</td>
            <td><input type="text" name="loginName"/></td>
            <td>密码：</td>
            <td><input type="password" name="loginPwd"/></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="staffName" id="staffAction_add_staffName"/></td>
            <td>性别：</td>
            <td><input type="radio" name="gender" value="男"/>男
                <input type="radio" name="gender" value="女"/>女
            </td>
        </tr>
        <tr>
            <td width="10%">所属部门：</td>
            <td width="20%">
                <select name="post.department.depName" onchange="onChange(this.value)" id="post">
                    <option value="-1">----请--选--择----</option>
                    <c:forEach items="${sessionScope.allDep}" var="dep">
                        <option>${dep.depName}</option>
                    </c:forEach>
                </select>

            </td>

            <td width="8%">职务：</td>
            <td width="62%">
                <select id="postSelectId" name="post.postID">
                    <option value="-1">----请--选--择----</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%">入职时间：</td>
            <td width="20%">
                <input type="text" name="onDutyDate" value="" readonly="readonly"
                       onfocus="c.showMoreDay=true; c.show(this);"/>
            </td>
            <td width="8%"></td>
            <td width="62%"></td>
        </tr>
    </table>

</form>

<%--验证的错误信息--%>
<s:fielderror fieldName="staff.loginName"></s:fielderror>

<%--二级联动--%>
<script type="application/javascript">

    function onChange(value) {

        // 输出value的值
        console.log(value);

        // 根据value的值（部门名称）发送请求，获取职务列表的json数据
        var data = new FormData();
        data.append("post.department.depName", value);

        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {

            if (this.readyState === 4) {
                // 对请求回来的数据进行解析
                json = eval('(' + this.responseText + ')');

                console.log(json);

                // 获取下拉列表的标签
                serverSelect = document.getElementById("postSelectId");

                // 获取option标签
                optionELe = serverSelect.getElementsByTagName("option");

                // 获取option的数量
                length = optionELe.length;

                // 使用查询清空所有的option标签
                for (var i = 0; i < length - 1; i++) {
                    serverSelect.removeChild(optionELe[1]);
                }

                if (json != null) {

                    // 将json查询插入到option中
                    for (var i = 0; i < json.length; i++) {
                        // 创建一个option标签
                        option = document.createElement("option");

                        // 设置value属性
                        option.setAttribute("value", json[i].postID);

                        // 设置文本信息
                        text = document.createTextNode(json[i].postName);

                        // 把文本信息添加到option标签中
                        option.appendChild(text);

                        // 把option标签添加到servers标签中
                        serverSelect.appendChild(option);
                    }

                }

            }

        });
        xhr.open("POST", "staffAction_findPost.action");
        xhr.send(data);
    }

</script>

</body>

</html>
