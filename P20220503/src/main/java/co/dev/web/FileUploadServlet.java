package co.dev.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/fileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FileUploadServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("title: " + title + ", content: " + content);
		
		
		String saveDir = "upload";
		saveDir = getServletContext().getRealPath(saveDir); //최상위에 존재하는 프로젝트 이름을 기준으로 실제 폴더가 있는 위치의 정보를 가져옴
		int maxSize = 1024 * 1024 * 10;
		String encoding = "utf-8";
		
		// multipart 요청을 받으면 알아서 파일을 업로드해줌
		// multipart request에 다섯 가지 정보만 넣어주면 됨 
		//요청 정보(request), 업로드된 파일이 저장되는 위치, 업로드하는 파일의 최대 크기, 인코딩 방식, 리네임정책(서버에 파일을 올렸는데 똑같은 이름의 파일 이름 있을 때)
		
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		title = multi.getParameter("title");
		content = multi.getParameter("content");
		String profile = multi.getOriginalFileName("profile"); // 업로드할 때 올린 파일 이름 그대로
		String fileName = multi.getFilesystemName("profile"); // 리네임 정책에 의해서 똑같은 파일이 있으면 바뀐 파일 이름 -> 이걸 알고 있어야 함 -> 이유
		System.out.println("title1: " + title + ", content1: " + content + ", profile: " + profile + ", file: " + fileName);
		
	}

}
