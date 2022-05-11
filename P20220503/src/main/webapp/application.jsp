<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application.jsp</title>
</head>
<body>
	<%
		String name = (String) application.getAttribute("name"); // getAtrribute 는 오브젝트를 반환하므로 캐스팅 필요
		out.print("<h3>" + name + "</h3>");
	%>
</body>
</html>