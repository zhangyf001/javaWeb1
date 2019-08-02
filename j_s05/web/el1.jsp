<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	pageContext.setAttribute("info1","page范围的值");
	request.setAttribute("info2","request范围的值");
	session.setAttribute("info3","session范围的值");
	application.setAttribute("info4","application范围的值");
	
	pageContext.setAttribute("info","page范围的值");
	request.setAttribute("info","request范围的值");
	session.setAttribute("info","session范围的值");
	application.setAttribute("info","application范围的值");
%>
<h1>${info1 },${info2 },${info3},${info4 }</h1>

<h1>${info }</h1><!-- 寻找值顺序：page/request/session/application -->
</body>
</html>