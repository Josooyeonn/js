package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// multipart request 요청이 들어오면 다섯 가지 정보만 넣어주면 됨 
		//요청 정보(request), 업로드된 파일이 저장되는 위치, 업로드하는 파일의 최대 크기, 인코딩 방식, 리네임정책(서버에 파일을 올렸는데 똑같은 이름의 파일 이름 있을 때)
		String saveDir = "upload";
		saveDir =request.getServletContext().getRealPath(saveDir); //최상위에 존재하는 프로젝트 이름을 기준으로 실제 폴더가 있는 위치의 정보를 가져옴
		int maxSize = 1024 * 1024 * 10;
		String encoding = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		System.out.println("입력처리하는 컨트롤입니다.");
		String id = multi.getParameter("id"); // request. 을 multi. 로 다 바꿔줌
		String ps = multi.getParameter("passwd");
		String nm = multi.getParameter("name");
		String em = multi.getParameter("email");
		String pf = multi.getFilesystemName("profile");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(nm);
		vo.setEmail(em);
		vo.setPasswd(ps);
		vo.setProfile(pf);
		
		MemberService service = new MemberService();
		service.memberInsert(vo);
		
		request.setAttribute("id", id);
		request.setAttribute("name", nm);
		
		// Dispatcher 객체 forward.
		request.getRequestDispatcher("memberResult/memberInsertOutput.jsp").forward(request, response);
	
	}

}
