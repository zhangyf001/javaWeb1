<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'register.jsp' starting page</title>

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
		<h1>
			注册
		</h1>
		<form action="RegisterServlet" method="post">
			<p>
				姓名:
				<input type="text" onblur="check(this.value)" name="aname" />
				<!-- <span id="aname_span">用户名必须是XXX</span> -->
			</p>

			<p>
				密码:
				<input type="password" name="apwd" />
			</p>
			
			<p>
			验证码:<input type="text" style="width: 70px" name="yanzheng"/>
			<img alt="" src="image.jsp" onclick="src='image.jsp?id='+Math.random()">
			</p>
			<p>
				<input type="submit" value="提交" />

			</p>

		</form>

	</body>
</html>
