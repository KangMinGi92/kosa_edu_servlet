package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;

@WebServlet(urlPatterns = {"/Find"}, loadOnStartup = 1)
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성...
		/*
		 	1. 한글처리.. 양방향 전부 다
		 	2. 폼값 받아오기
		 	3. DAO 받아와서... 비지니스로직 호출... 이때 2번의 폼값을 인자값으로 넣어서 호출
		 	4. 반환값... VO
		 	5. VO를 Attribute에 바인딩
		 	6. 페이지 이동(forward)
		 */
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		//DAO... BIZ... VO반환...
		
		Member member=new Member("kosa","1234","강민기");
		
		//VO를 Attribute에 바인딩
		request.setAttribute("member", member);
		//페이지 이동
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}
}
