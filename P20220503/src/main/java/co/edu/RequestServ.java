package co.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/request1.do")
public class RequestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RequestServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); // request.jsp에서 id와 name이라는 속성을 받음 
		String name = request.getParameter("name");
		request.setAttribute("id", id); // 요청정보에 id라는 키값에 받아온 id 값을 넣음
		request.setAttribute("name", name); // name파라미터에 있던 값을 읽어온 걸 name에 넣음
		
		StudentDAO dao = new StudentDAO();
		Student result = dao.searchStudent(id);
		request.setAttribute("result", result); // 요청 정보에 추가적인 값을 result라는 이름을 추가함
		
		
		//response.jsp
		//페이지 재지정하는 방법이 두 개
		request.getRequestDispatcher("response.jsp").forward(request, response); // 이 페이지에서 request와 response가 가지고 있던 정보를 그대로 가지고 response로 넘기는 메소드
		//response.sendRedirect("response.jsp"); // 위와 다른 점은 request한 값을 공유할 방법이 없다 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
