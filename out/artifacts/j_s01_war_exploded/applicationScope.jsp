<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 设置两个application范围的数据 key-> value 在整个服务器上保存数据，可以多个浏览器上取数据。
	application.setAttribute("name","application王二小");
	application.setAttribute("age",12);
%>
<h1>application值设置完毕！</h1>
</body>
</html>