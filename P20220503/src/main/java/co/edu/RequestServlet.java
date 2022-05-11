package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestServlet.do")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException { // 최초 호출시에만 실행 웹페이지에서 새로고침하면 최초요청이 아니라서 실행안함
		System.out.println("init() call.");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) // request, response 서블릿을 호출하면
																						// 호출하기전에 웹 컨테이너가 객체를 생성하고 그걸
																						// 서비스가 매개값으로 받음 요청정보, 응답처리 목적
																						// 요청 정보 ex.getParameter 응답처리 ex.getWriter
			throws ServletException, IOException {
		System.out.println("service() call.");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); // 출력되는 페이지의 형식
		
		PrintWriter out = response.getWriter(); // 출력스트림
		// 아래와 같은 정보들이 포함됨
		
		out.print("<h3>홍길동</h3>");
		out.print("<h3>네트워크정보</h3>");
		out.print("Request Scheme: " + request.getScheme()+"<br>");
		out.print("Server Name: " + request.getServerName() + "<br>");
		out.print("Server Address: " + request.getLocalAddr() + "<br>");
		out.print("Client Address: " + request.getRemoteAddr() + "<br>");
		out.print("Client Port: " + request.getRemotePort() + "<br>");
		
		out.print("<h3>요청 프로토콜</h3>");
		out.print("Request URI: " + request.getRequestURI() + "<br>");
		out.print("Request URL: " + request.getRequestURL() + "<br>");
		out.print("Context path: " + request.getContextPath() + "<br>"); // 프로젝트이름
		out.print("Request protocol: " + request.getProtocol() + "<br>");
		out.print("Server Paht: " + request.getServletPath() + "<br>"); // 요청한 페이지
	
		out.print("queryString: " + request.getQueryString() + "<br>"); // 넘어온 파라미터 정보
		out.print("id: " + request.getParameter("id") + "<br>"); // 파라미터 이름이 id에 해당하는 값 받아오기
		out.print("pawd: " + request.getParameter("passwd") + "<br>"); // 파라미터가 passwd라고 지정된 것의 값
		out.print("name: " + request.getParameter("username") + "<br>"); // 파라미터가 username이라고 지정된 것의 값
		
		out.close();
		
	}

}
