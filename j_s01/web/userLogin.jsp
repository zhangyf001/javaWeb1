<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	String userName=request.getParameter("userName");  
	String pwd=request.getParameter("pwd"); 
	String remember=request.getParameter("remember"); 
	
	if("remember-me".equals(remember)){//设置cookie
		Cookie userNameAndPwd=new Cookie("userNameAndPwd",userName+"-"+pwd);
		userNameAndPwd.setMaxAge(1*60*60*24*7); // cookie记录一个星期
		response.addCookie(userNameAndPwd);  // 保存cookie
		System.out.println("设置Cookie成功");
	}
	response.sendRedirect("response03.jsp");
%>

</body>
</html>