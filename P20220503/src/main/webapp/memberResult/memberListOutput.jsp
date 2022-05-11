<%@page import="co.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberResult/memberListOutput.jsp</title>
</head>
<body>

<!-- 자바소스로 복잡하게 쓰던 걸 전부 태그로 쓰려고 하는 작업 -->
<c:choose> 
	<c:when test="${empty all }"><h3>회원정보가 없습니다.</h3></c:when> 
	<c:otherwise> 
		<table border="1">
			<thead><tr><th>아이디</th><th>이름</th><th>이메일</th><th>비밀번호</th><th>이미지</th></tr>
			<tbody>
				<c:forEach items="${all }" var="member"> 
					<tr>
						<td>${member.id }</td>
						<td>${member.name }</td>
						<td>${member.email }</td>
						<td>${member.passwd }</td>
						<td>
						  <c:if test="${!empty member.profile }">	
							<img width="70px" src ="${pageContext.servletContext.contextPath }/upload/${member.profile }"></td>
						  </c:if>	
					</tr>
								
				</c:forEach>	
			</tbody>
		</table>
	</c:otherwise>
</c:choose>

	<!-- 16 : if-else 구문 쓰기 위함 -->
	<!-- 17 : 참이면 실행 if는 if하나만 쓸 때 choose 쓸 때는 when otherwise -->
	<!-- 18 : 거짓이면 실행 -->
	<!-- 22 : 반복문. items : 리스트 var : 한건씩 받아와서 변수에 담음 -->
	<!-- 23 : memberVO에서 정의된 속성들. get 대신에 그냥 필드 이름만 쓰면 됨 -->
	
 <jsp:include page="home.jsp"></jsp:include> <!-- jsp에서 기본적으로 제공해주는 태그 확장된 태그 기능도 있는데 쓰려면 라이브러리를 추가해야함 jstl 검색 --> 
</body>
</html>