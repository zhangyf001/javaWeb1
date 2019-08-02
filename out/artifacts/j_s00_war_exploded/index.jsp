<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--Language : 用来定义要使用的脚本语言；
contentType：定义 JSP 字符的编码和页面响应的 MIME 类型；
pageEncoding：Jsp 页面的字符编码--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String str="全局变量";
%>
<%!
	public void fun1(){
		System.out.println("全局方法");
	}
%>
<%!
	class C{
		private int a;
		public void f(){
			System.out.println("全局类");
		}
	}
%>
<%
	int a=1234;
	String b="java";
	out.println(a+b+"局部变量");
%>

<%=b %>
<!-- html注释 客户端课可见 -->
<%-- jsp注释 客户端不可见 --%>
<br/>
<%@ include file="footer.jsp" %>  <%--静态包含  先包含 后编译处理--%> <br/>

<jsp:include page="content.jsp"/> <%--动态包含  先编译处理 后包含--%>  


<!--服务器内部跳转-->

<jsp:forward page="target.jsp">

<jsp:param value="zhangsan" name="userName"/>
<jsp:param value="21" name="age"/>

</jsp:forward>





</body>
</html>