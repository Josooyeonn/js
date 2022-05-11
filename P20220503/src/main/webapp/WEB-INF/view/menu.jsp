<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면입니다.</title>
</head>
<body>

	<!-- jsp의 목적은 대체적으로 뷰 memberInsert.jsp 목적 회원정보등록-->

	<div class="border-end bg-white" id="sidebar-wrapper">
		<div class="sidebar-heading border-bottom bg-light">Menu List</div>
		<div class="list-group list-group-flush">
			<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="${pageContext.request.contextPath }/memberView/memberInsert.tiles">회원정보생성</a>
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/memberView/memberSearch.jsp">회원정보검색</a>
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/memberView/memberUpdate.jsp">회원정보수정</a>
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/memberView/memberDelete.jsp">회원정보삭제</a> 
			<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="${pageContext.request.contextPath }/memberList.do">모든회원정보</a>
			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/ajax.html">Ajax 호출</a>
		</div>
	</div>
</body>
</html>
