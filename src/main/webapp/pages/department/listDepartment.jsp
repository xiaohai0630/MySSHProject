<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>

    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>

</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[部门管理]</td>

        <td width="57%" align="right">
            <%--添加部门 --%>
            <a href="${pageContext.request.contextPath}/pages/department/addOrEditDepartment.jsp">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1">

    <tr class="henglan" style="font-weight:bold;">
        <td width="6%" align="center">部门名称</td>
        <td width="7%" align="center">编辑</td>
    </tr>

    <%--循环显示全部的部门信息--%>
    <c:forEach items="${sessionScope.allDep}" var="dep" varStatus="vs">

        <%--保持两种颜色交替--%>
        <c:if test="${vs.index%2==0}">
            <tr class="tabtd1">
                <td align="center">${dep.depName}</td>
                <td width="7%" align="center">
                    <a href="depAction_addOrEditDepartment.action?addOrEditDep=${dep.depID}"><img
                            src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
                </td>
            </tr>
        </c:if>

        <c:if test="${vs.index%2!=0}">
            <tr class="tabtd2">
                <td align="center">${dep.depName}</td>
                <td width="7%" align="center">
                    <a href="depAction_addOrEditDepartment.action?addOrEditDep=${dep.depID}"><img
                            src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
                </td>
            </tr>
        </c:if>

    </c:forEach>

</table>


<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            <span>第1/3页</span>
            <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
        </td>
    </tr>
</table>

</body>

</html>
