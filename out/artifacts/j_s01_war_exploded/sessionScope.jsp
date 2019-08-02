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
	// 设置两个session范围的数据 key-> value   只在一次会话中保存信息，信息保存在服务器中，只能在单个个浏览器中取数据，
	//只要不关闭浏览器就可以一直取得数据(默认半小时时间限制)
	session.setAttribute("name","session王二小");
	session.setAttribute("age",12);
%>
<h1>session值设置完毕！</h1><!-- 访问时 得先访问设置sessionScope.jps再访问sessionTarget.jsp  -->
</body>
</html>