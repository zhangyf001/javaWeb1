<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="model.Student" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
javabean组件的引入
<%
	Student student=new Student();
	student.setName("王二小");
	student.setAge(12);
%>
<h1>姓名：<%=student.getName() %></h1>
<h1>年龄：<%=student.getAge() %></h1>
</body>
</html>