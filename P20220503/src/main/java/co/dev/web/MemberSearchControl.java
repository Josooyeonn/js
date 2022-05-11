package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberSearchControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 에러 나면 돌아가는 페이지 다르게 지정  
		String id = request.getParameter("id");
		String job = request.getParameter("job");
		
		String path = "";
		if(job.equals("search")) {
			path = "memberView/memberSearch.jsp";
		} else if(job.equals("update")) {
			path = "memberView/memberUpdate.jsp";
		} else if(job.equals("delete")) {
			path = "memberView/memberDelete.jsp";
		}
		
		if(id.isEmpty()) {
			request.setAttribute("error", "아이디를 입력하세요.");
			request.getRequestDispatcher(path).forward(request, response);
			return; // 메소드 종료
		}
		
		MemberService service = new MemberService();
		MemberVO member = service.memberSearch(id); // member는 참조주소값을 가지고 있음
		
		if(member == null) {
			request.setAttribute("result", "조회된 정보가 없습니다.");
		} else {
			request.setAttribute("member", member);
		}
		
		if (job.equals("search")) {
			path = "memberResult/memberSearchOutput.jsp";
		} 
		request.getRequestDispatcher(path).forward(request, response);
		
	}	

}
