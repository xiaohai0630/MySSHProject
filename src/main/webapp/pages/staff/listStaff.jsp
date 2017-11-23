<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <td width="39%" align="left">[员工管理]</td>

        <td width="57%" align="right">
            <%--高级查询 document.forms[0].submit() --%>
            <a href="javascript:void(0)" onclick="condition()"><img
                    src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"/></a>
            <%--员工注入 --%>
            <a href="/pages/staff/addStaff.jsp">
                <img src="/images/button/tianjia.gif"/>
            </a>

        </td>
        <td width="3%" align="right"><img src="/images/tright.gif"/></td>
    </tr>
</table>

<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="staffAction_findStaffWithMsg.action" method="post">
    <table width="88%" border="0" style="margin: 20px;">
        <tr>
            <td width="80px">部门：</td>
            <td width="200px">

                <select name="post.department.depID" onchange="onChange(this.value)" id="depSelectId">
                    <option value="-1">--请选择部门--</option>
                    <c:forEach items="${sessionScope.allDep}" var="dep">
                        <option value="${dep.depID}">${dep.depName}</option>
                    </c:forEach>
                </select>

            </td>
            <td width="80px">职务：</td>
            <td width="200px">

                <select name="post.postID" id="postSelectId">
                    <option value="-1">--请选择职务--</option>
                </select>

            </td>
            <td width="80px">姓名：</td>
            <td width="200px"><input type="text" name="staffName" size="12" id="staffNameSelectId"/></td>
            <td></td>
        </tr>
    </table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1" id="tab">
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">员工姓名</td>
        <td width="6%" align="center">性别</td>
        <td width="12%" align="center">入职时间</td>
        <td width="15%" align="center">所属部门</td>
        <td width="10%" align="center">职务</td>
        <td width="10%" align="center">编辑</td>
    </tr>

    <c:forEach items="${sessionScope.allStaff}" var="staff" varStatus="vs">

        <%--白蓝相间的效果，vs：相当于下标--%>
        <c:if test="${vs.index%2==0}">
            <tr class="tabtd1">
        </c:if>
        <c:if test="${vs.index%2!=0}">
            <tr class="tabtd2">
        </c:if>

        <td align="center">${staff.staffName}</td>
        <td align="center">${staff.gender}</td>
        <td align="center"><fmt:formatDate value="${staff.onDutyDate}" pattern="yyyy-MM-dd"/></td>
        <td align="center">${staff.post.department.depName}</td>
        <td align="center">${staff.post.postName}</td>
        <td width="7%" align="center">

            <a href="staffAction_editStaffList.action?editStaff=${staff.staffID}">
                <img src="/images/button/modify.gif" class="img"/>
            </a>
        </td>
        </tr>

    </c:forEach>

</table>

<%--二级联动和高级查询--%>
<script type="application/javascript">
    function onChange(value) {
        //输出value的值
        console.log(value);
        //根据value的值发送请求,获取二级列表的json数据
        var data = new FormData();
        data.append("post.department.depID", value);

        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                console.log(this.responseText);
                //对请求回来的数据进行解析
                json = eval('(' + this.responseText + ')');

                console.log(json);

                //获取服务器的标签
                serverSelect = document.getElementById("postSelectId");
                //获取option标签
                optionEle = serverSelect.getElementsByTagName("option");
                //获取option的数量
                length = optionEle.length;
                //使用循环清空所有option标签
                for (var i = 0; i < length - 1; i++) {
                    serverSelect.removeChild(optionEle[1]);
                }
                if (json != null) {
                    //将json数据插入到option中
                    for (var i = 0; i < json.length; i++) {
                        //创建一个option标签
                        option = document.createElement("option");
                        //设置value属性
                        option.setAttribute("value", json[i].postID);
                        //设置文本信息
                        text = document.createTextNode(json[i].postName);
                        //把文本信息添加到option标签中
                        option.appendChild(text);
                        //把option标签添加到servers标签中
                        serverSelect.appendChild(option);
                    }

                }

            }

        });

        xhr.open("POST", "staffAction_findPost.action");
        xhr.send(data);
    }

    // 高级查询
    function condition() {
        // 获取查询条件－－部门id，职务id，员工姓名
        var data = new FormData();
        data.append("post.department.depID", document.getElementById("depSelectId").value);
        data.append("post.postID", document.getElementById("postSelectId").value);
        data.append("staffName", document.getElementById("staffNameSelectId").value);

        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                //对请求回来的数据进行解析
                json = eval('(' + this.responseText + ')');

                // 返回值
                console.log(json);

                // 获取表格的标签
                serverSelect = document.getElementById("tab");
                // 获取tr标签
                optionEle = serverSelect.getElementsByTagName("tr");
                // 获取tr的数量
                length = optionEle.length;
                // 删除第一行以外的tr标签
                for (var i = length - 1; i > 0; i--) {
                    optionEle[i].remove();
                }

                if (json != null) {
                    // 将json数据插入到tr中
                    for (var i = 0; i < json.length; i++) {
                        // 创建一个tr标签
                        option = document.createElement("tr");
                        optionChild1 = document.createElement("td");
                        optionChild2 = document.createElement("td");
                        optionChild3 = document.createElement("td");
                        optionChild4 = document.createElement("td");
                        optionChild5 = document.createElement("td");

                        // 编辑（图标和链接）
                        optionChild6 = document.createElement("td");

                        // 白蓝相间的效果
                        if (i % 2 == 0) {
                            option.setAttribute("class", "tabtd1");
                        } else {
                            option.setAttribute("class", "tabtd2");
                        }

                        // 为每一列添加内容
                        optionChild1.setAttribute("align", "center");
                        optionChild2.setAttribute("align", "center");
                        optionChild3.setAttribute("align", "center");
                        optionChild4.setAttribute("align", "center");
                        optionChild5.setAttribute("align", "center");

                        text = document.createTextNode(json[i].staffName);
                        optionChild1.appendChild(text);
                        option.appendChild(optionChild1);

                        text = document.createTextNode(json[i].gender);
                        optionChild2.appendChild(text);
                        option.appendChild(optionChild2);

                        // 截取第0位到第10位
                        var onDutyDate = json[i].onDutyDate;
                        var duty = onDutyDate.substring(0, 10);

                        text = document.createTextNode(duty);
                        optionChild3.appendChild(text);
                        option.appendChild(optionChild3);

                        text = document.createTextNode(json[i].post.department.depName);
                        optionChild4.appendChild(text);
                        option.appendChild(optionChild4);

                        text = document.createTextNode(json[i].post.postName);
                        optionChild5.appendChild(text);
                        option.appendChild(optionChild5);

                        // 编辑
                        optionChild6.setAttribute("width", "7%");
                        optionChild6.setAttribute("align", "center");

                        // 创建一个a标签
                        optionChild6A = document.createElement("a");
                        optionChild6A.setAttribute("href",
                                "staffAction_editStaffList.action?editStaff=" + json[i].staffID);
                        optionChild6.appendChild(optionChild6A);

                        // 添加图片（编辑的图标）
                        optionChild6AImg = document.createElement("img");
                        optionChild6AImg.setAttribute("src", "/images/button/modify.gif");
                        optionChild6AImg.setAttribute("class", "img");
                        optionChild6A.appendChild(optionChild6AImg);

                        option.appendChild(optionChild6);

                        //把option标签添加到servers标签中
                        serverSelect.appendChild(option);
                    }

                }

            }

        });

        xhr.open("POST", "staffAction_findStaffWithMsg.action");
        xhr.send(data);
    }

</script>

</body>
</html>
