<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="js/jquery-1.11.3.min.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	a
    <form action="a.zyf" method="post">
    	<input type="text" name="uname"/>
    	<input type="submit" value="提交"/>
    
    </form> <br>
    b <form action="b.zyf" method="post">
    	<input type="text" name="uname"/>
    	<input type="submit" value="提交"/>
    
    </form>
     e <form action="e.zyf" method="post">
     	编号：<input type="text" name="id"/>
    	名字<input type="text" name="name"/>
    	<input type="submit" value="提交"/>
    
    </form>
   
    
    
    
  </body>
</html>
