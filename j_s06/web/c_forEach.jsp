<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="po.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String dogs[]={"小黑","小黄","小白","小小"};
    pageContext.setAttribute("dogs",dogs);
%>
<c:forEach var="e" items="${dogs }"><!-- 下标从0开始 -->
	${e }
</c:forEach>
<hr/>
<c:forEach var="e" items="${dogs }" step="2"><!-- 步进2  小黑小白-->
	${e }
</c:forEach>
<hr/>
<c:forEach var="e" items="${dogs }" begin="1" end="2"><!--小黄小白-->
	${e }
</c:forEach>
<hr/>
<%
	List<People> pList=new ArrayList<People>();
    pList.add(new People(1,"张三",10));
    pList.add(new People(2,"李四",20));
    pList.add(new People(3,"王五",30));
    pageContext.setAttribute("pList",pList);
%>
<table>
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>年龄</th>
	</tr>
	<c:forEach var="p" items="${pList }">
		<tr>
			<td>${p.id }</td>
			<td>${p.name }</td>
			<td>${p.age }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>