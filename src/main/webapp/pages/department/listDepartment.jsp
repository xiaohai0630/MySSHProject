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

<table width="100%" border="1" id="tab">

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
            <span id="page">第1/3页</span>
            <span>
        	<a href="#" onclick="firstPage(this.id)" id="firstPage">[首页]</a>&nbsp;&nbsp;
            <a href="#" onclick="firstPage(this.id)" id="upPage">[上一页]</a>&nbsp;&nbsp;
            <a href="#" onclick="firstPage(this.id)" id="downPage">[下一页]</a>&nbsp;&nbsp;
            <a href="#" onclick="firstPage(this.id)" id="lastPage">[尾页]</a>
        </span>
        </td>
    </tr>
</table>

<%--分页--%>
<script type="application/javascript">

    // 首页
    function firstPage(value) {

        // 参数是1
        var data = new FormData();
        data.append("changePage", value);

        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {

            if (this.readyState === 4) {
                // 对请求回来的数据进行解析
                json = eval('(' + this.responseText + ')');

                console.log(json);

                // 获取表格的标签
                serverSelect = document.getElementById("tab");
                // 获取tr标签
                optionELe = serverSelect.getElementsByTagName("tr");
                // 获取tr的数量
                nums = optionELe.length;

                // 删除第一行以外的tr标签
                for (var i = nums - 1; i > 0; i--) {
                    optionELe[i].remove();
                }

                if (json != null) {

                    // 将json查询插入到option中
                    for (var i = 0; i < json.length; i++) {

                        // 创建tr标签
                        trs = document.createElement("tr");
                        // 部门名称
                        tds1 = document.createElement("td");
                        // 编辑
                        tds2 = document.createElement("td");
                        // 图片
                        tdsPic = document.createElement("img");

                        if (i % 2 == 0) {
                            // tr
                            trs.setAttribute("class", "tabtd1");
                            // 给两个td添加属性
                            tds1.setAttribute("align", "center");

                            tds2.setAttribute("align", "center");
                            tds2.setAttribute("width", "7%");

                            // 部门名称
                            text = document.createTextNode(json[i].depName);
                            tds1.appendChild(text);
                            trs.appendChild(tds1);

                            // a标签
                            tdsA = document.createElement("a");
                            tdsA.setAttribute("href",
                                    "depAction_addOrEditDepartment.action?addOrEditEep=" + json[i].depID);

                            // 编辑的图标
                            tdsPic.setAttribute("src",
                                    "${pageContext.request.contextPath}/images/button/modify.gif");

                            // 图片添加到a标签，添加到tr
                            tdsA.appendChild(tdsPic);
                            tds2.appendChild(tdsA);

                            // 把td添加到tr中
                            trs.appendChild(tds2);

                            serverSelect.appendChild(trs);
                            // 页码
                            document.getElementById("pageID");

                        } else {
                            // tr
                            trs.setAttribute("class", "tabtd2");
                            // 给两个td添加属性
                            tds1.setAttribute("align", "center");
                            tds2.setAttribute("align", "center");
                            tds2.setAttribute("width", "7%");
                            // 部门名称
                            text = document.createTextNode(json[i].depName);
                            tds1.appendChild(text);

                            // a标签
                            tdsA = document.createElement("a");
                            tdsA.setAttribute("href",
                                    "depAction_addOrEditDepartment.action?addOrEditEep=" + json[i].depID);
                            trs.appendChild(tds1);

                            // 编辑的图标
                            tdsPic.setAttribute("src",
                                    "${pageContext.request.contextPath}/images/button/modify.gif");

                            // 图片添加到a标签，添加到tr
                            tdsA.appendChild(tdsPic);
                            tds2.appendChild(tdsA);

                            // 把td添加到tr中
                            trs.appendChild(tds2);

                            serverSelect.appendChild(trs);

                            // 页码
                            document.getElementById("pageID");
                        }

                    }

                }

            }

        });
        xhr.open("POST", "depAction_depListPageBean.action");
        xhr.send(data);
    }

</script>

</body>
</html>
