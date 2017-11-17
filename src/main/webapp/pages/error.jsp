<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<font color="#f00">
    系统繁忙，请稍后重试
</font>

<%--出错返回上一个页面？--%>
<a href="javascript:void(0)" onclick="window.history.go(-1)">
    <img src="${pageContext.request.contextPath}/images/button/tuihui.gif" />
</a>

</body>
</html>
