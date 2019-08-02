<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:url value="http://www.baidu.com" var="url">
	<c:param name="name" value="xiaofeng"></c:param>
	<c:param name="age" value="26"></c:param>
</c:url>
<!-- 点击这个URL，访问这个：https://www.baidu.com/?name=xiaofeng&age=26 -->
<a href="${url }">百度一下</a>
</body>
</html>