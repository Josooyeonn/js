<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDelete.jsp</title>
</head>
<body>
	${error }
	<h3>삭제할 회원 정보</h3>
	<form action="${pageContext.servletContext.contextPath }/memberSearch.do" method="get">
	조회 아이디 : <input type="text" name="id"><br> <!-- 넘어가는 파라미터가 id, job 두개 -->
	<input type="hidden" name="job" value="delete"> 
	<input type="submit" value="Search"> </form>
	
	<h3>회원 정보 삭제</h3>
	<form action="${pageContext.servletContext.contextPath }/memberDelete.do" method="get">
	삭제할 아이디 : <input type="text" name= "id" value = "${member.id}"><br>
	<input type="submit" value="삭제">
	</form>
	
	<jsp:include page="home.jsp"></jsp:include>
	

</body>
</html>