<%@page import="co.edu.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response.jsp</title>
</head>
<body>
 <%
 	String id = (String) request.getAttribute("id"); // request 요청정보에 있는 값을 읽어옴(포워딩 받은 값), 요청단위당 공유 
 													 // response, request 객체는 사용하고 메모리에서 사라지므로 다른 단위에서는 이거 못씀  
 												     // 캐스팅 : 겟어트리뷰트가 오브젝트 타입을 가져오기때문
 	String name = (String) request.getAttribute("name");
 	Student student = (Student) request.getAttribute("result"); // result에 지정되어있는 참조 주소값을 반환
 %>
 
 <h3>id: <%=id %></h3> <!-- 자바영역에서 아이디 변수에 담긴 값을 읽어오는 법 -->
 <h3>name: <%=name %></h3>
 <h3>no: <%=student.getStudentNo() %></h3>
 <h3>name: <%=student.getStudentName() %></h3>
</body>
</html>
<!--            받아온 요청 정보에 setAttribute --- 최종결과값을 보여주는 페이지  이 두 개가 값을 공유한다   -->     
<!-- request.jsp -> request1.do -> response.jsp -->
        <!-- 파라미터값으로 넘김  요청정보라는 객체에 id, name을 담아서 포워딩 -->