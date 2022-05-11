<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberResult/memberInsertOutput.jsp</title>   <!-- 정보를 알려주는 페이지 -->
</head>
<body>
	<h3>${name }님 가입이 완료되었습니다.</h3> <!-- jsp 표현식. true, false, 문자 정수값등이 올 수 있음. 표현식은 내장객체를 가짐. html 영역에서 자바를 쓰는 아래의 방법보다 훨씬 간단 -->
	<%-- <h3><%=(String) request.getAttribute("name")%>님 가입이 완료되었습니다.</h3> --%>
	<jsp:include page="home.jsp"></jsp:include> <!-- html안에 태그 형식으로 넣어주면 file 대신 page가 됨 -->
	<%-- <%@include file="home.jsp"%> <!--  꺽쇠 퍼센트 골뱅이 뒤에 페이지 정보, 임포트 정보 등이 올 수 있음 --> --%> 
</body>
</html>