package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertJson implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 인서트 작업하고 다른 곳으로 가면 안되고 그 결과를 리턴해야함 
		response.setContentType("text/json;charset=utf-8");
		MemberVO vo = null;
		boolean isMulti = ServletFileUpload.isMultipartContent(request); //멀티파트 형식인지 아닌지
		 
		if(isMulti) { // 멀티파트 요청일 때 (파일이 첨부됨)
			
			String saveDir = "upload";
			saveDir =request.getServletContext().getRealPath(saveDir); //최상위에 존재하는 프로젝트 이름을 기준으로 실제 폴더가 있는 위치의 정보를 가져옴
			int maxSize = 1024 * 1024 * 10;
			String encoding = "utf-8";
			
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
			
			System.out.println("입력처리하는 컨트롤입니다.");
			String id = multi.getParameter("id"); 
			String ps = multi.getParameter("passwd");
			String nm = multi.getParameter("name");
			String em = multi.getParameter("email");
			String pf = multi.getFilesystemName("profile");
			
			vo = new MemberVO();
			vo.setId(id);
			vo.setName(nm);
			vo.setEmail(em);
			vo.setPasswd(ps);
			vo.setProfile(pf);
			
			MemberService service = new MemberService();
			service.memberInsert(vo);
			
			
			
		} else { // key1=value1&key2=value2 형식일때
			String id = request.getParameter("id"); 
			String ps = request.getParameter("passwd");
			String nm = request.getParameter("name");
			String em = request.getParameter("email");
			
			vo = new MemberVO();
			
			vo.setId(id);
			vo.setName(nm);
			vo.setEmail(em);
			vo.setPasswd(ps);
			
			MemberService service = new MemberService();
			service.memberInsert(vo);
			
		}
		// output으로 가면 안되고 json 형태의 결과를 리턴해야함
					Gson gson = new GsonBuilder().create();
					response.getWriter().print(gson.toJson(vo));
	}

}
