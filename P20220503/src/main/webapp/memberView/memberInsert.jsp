<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView/memberInsert.jsp</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="../memberInsert.do" method="post" enctype="multipart/form-data">
		아이디: <input type="text" name="id"><br> <!-- name 속성은 파라미터의 이름 -->
		비밀번호: <input type="password" name="passwd"><br>
		이름: <input type="text" name="name"><br>
		메일: <input type="email" name="email"><br>
		이미지: <input type="file" name="profile"><br> 
		<input type="submit" value="추가"> <!-- submit을 누르면 memberInsert.do가 실행됨 .do로 끝나는 것들은 frontController에서 처리하기로했으니(web.xml에서) 거기로 가야함 -->
			
	</form>
	<jsp:include page="home.jsp"></jsp:include>

</body>
</html>