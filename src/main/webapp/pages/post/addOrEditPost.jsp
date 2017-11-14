<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>

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
        <td width="44%" align="left">[职务管理]</td>

        <td width="52%" align="right">
            <!-- 提交表单 -->
            <a href="javascript:void(0)" onclick="document.forms[0].submit()">
                <img src="${pageContext.request.contextPath}/images/button/save.gif"/>
            </a>
            <!-- 执行js，进行返回 -->
            <a href="javascript:void(0)"
               onclick="document.location='${pageContext.request.contextPath}/postAction_returnListPost'"><img
                    src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<form action="postAction_addOrEditPost.action" method="post">
    <table width="88%" border="0" class="emp_table" style="width:80%;">

        <tr>
            <td>选择部门：</td>
            <td>
                <select name="department.depID">
                    <option value="-1">----请--选--择----</option>
                    <c:forEach items="${sessionScope.allDep}" var="dep">
                        <c:if test="${sessionScope.addOrEditPost.department.depName == dep.depName}">
                            <option selected="selected" value="${dep.depID}">${dep.depName}</option>
                        </c:if>
                        <c:if test="${sessionScope.addOrEditPost.department.depName != dep.depName}">
                            <option value="${dep.depID}">${dep.depName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td>职务：</td>
            <td>
                <%--显示职务的名称，隐藏的属性是职务的id--%>
                <input type="text" name="postName" value="${sessionScope.addOrEditPost.postName}"/>
                <input type="hidden" name="postID" value="${sessionScope.addOrEditPost.postID}"/>

            </td>
        </tr>

    </table>

</form>

<h2>${sessionScope.wrongChoose}</h2>

</body>
</html>
