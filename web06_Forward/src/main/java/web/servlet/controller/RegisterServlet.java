package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;


/*
		Attribute
	서버상에서 정보를 저장하는 공간
	setAttribute("name",Object);
	getAttribute("name");
	
	저장되는 데이터의 Scope에 따라 3가지로 나뉜다.
	ServletRequest(Scope : 응답하기전)
	
	HttpSession(Scope : 로그인 동안)
	
	ServletContext(Scope : 서버 stop되기 전까지)
	
	
	페이지 이동에 따른 Attribute
	1. Forward방식
	서버상에서 다이렉트로 다른 컴포넌트로 이동하는 방식
	ServletRequest사용(응답 후 소멸)
	
	2.<a href="result.jsp"> Page Move</a>
	HttpSession사용
	
	3. Redirect
	 		헤더의 페이지방향을 바꾼다.
	 		로그인 후 메인페이지로 이동!
	 		response.sendRedirect("page");
	 	Forward방식과 Redirect방식의 차이점
		 	1). 요청, 응답수
		 	2). 사용가능한 Attribute
		 	3). 주소창 변경여부
		 	4). 다른서버의 컴포넌트 접근여부
		 		(redirect는 요청에 응답을해서 다음 요청을 http가 보내기때문에 같은서버 이외의 서버로 접근가능하다.)

*/
@WebServlet(urlPatterns = {"/Register"}, loadOnStartup = 2)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직 작성
		/*
		 	1.폼값 받아서
		 	2.DAO 반환받고
		 	3.biz logic 호출... registerMember(값)
		 	4.바인딩?
		 	5.네비게이션
		 */
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		
		Member pvo = new Member(id,pass,name);
		
		//request.setAttribute("vo", pvo);
		
		//세션에 바인딩
//		HttpSession session=request.getSession();
//		session.setAttribute("vo",pvo); //응답을 하더라도 계속 데이터를 저장(로그인동안)
		
		
		//servletContext에 바인딩
		getServletContext().setAttribute("vo",pvo);
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h3>");
		out.println("NextPage....");
		out.println("<a href='list.jsp'>ListServlet Page</a></h3>");
		out.println("</body></html>");
	}
}
