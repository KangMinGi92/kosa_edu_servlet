package web.servlet.form;

/*
 Servlet API
 Spec
 1) SE : LocalMachine
 2) EE : Browser and Server
	
 EE Spec의 Java Class와 SE Java Class와 차이저
 1) 브라우저에서 들어오는 요청을 처리하는 자바클래스
 2) 객체생성을 개발자가 직접 하지 않고 컨테이너가 알아서 생성
 	web.xml을 작성해야했지만 container에게 그 일을 위임하는것을 Annotation으로 처리한다.

 Client 요청방식
 1)GET : 모든 요청의 디폴트 90%의 요청이 GET요청 (Get It의 줄임말 단순한 페이지 연결방식!!)
 	==> page연결이 주목적이고 데이터 전달이 주목적이 아니다.
 	==> 데이터를 전달할때 주소창에 데이터가 노출
 	*전달되는 데이터가노출
 	*전달하는 데이터의 크기, 길이에 제약
 	
 2)POST : Post Office의 줄임말 데이터 전달이 주목적!!
 	==> 내가 ~~~~이런저런 데이터를 서버 프로그램쪽으로 보낼테니 프로그램은 그 데이터를 이용해서 처리한 결과를 나한테 보내줘 ~~
 	==> 처리할 데이터가 많은 경우, 보안상 감춰야하는 경우
 	*로그인/회원가입이 대표적인 POST방식 요청!!
 	*전달하는 데이터가 주소창에 노출안됨
 	*HttpServletRequest 에 담겨져서 전송됨
 	*전달하는 데이터의 크기, 길이에 제약이 없다.
 	
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//thread생성 -> service() -> doGet()
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 	1. 폼값 받아온다.
		 	2. 그 값을 그대로 화면에 출력
		 
		//한글처리는 request, response 각각 따로 처리해야 한다.
		response.setContentType("text/html;charset=utf-8");
		//여기서 request.setContentType("text/html;charset=utf-8"); 안해줘도 되는이유는 server.xml에 doget방식으로 불러올때 이미
		//한글 인코딩 (utf-8)을 선언해둬서 안해줘도 한글처리가 된다. 단, post사용시에는 까먹지말고 인코딩 처리 해야한다.
		
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		
		
		결과 페이지의 역할은 Servlet 역할이 아니다.
		Servlet 로직 중심의 기술이고
		Tag중심의 기술 JSP 에서 담당하도록 한다.
		
		PrintWriter out=response.getWriter();
		//response.setContentType("text/html;charset=utf-8"); 한글처리는 request,response 사용전 미리 세팅해야해서 최상단에 선언한다.
		
		out.println("<html><body>"); 
		out.println("<h2>당신의 이름은 "+name+"</h2>");
		out.println("<h2>당신이 사는곳은 "+addr+"</h2>");
		out.println("</body></html>");
		
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}*/
	
	//thread생성 -> service() -> doPost()
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Post 방식에서 한글처리는 request,response 사용전 미리해줘야한다. Get방식은 server.xml에서 request처리 해준다.
	//브라우저에서 서버로 보낼때 한글처리.. HttpServletRequest body 부분에 담긴 데이터 한글처리
	request.setCharacterEncoding("UTF-8");
	
	//서버에서 브라우저로 응답할때 한글처리
	response.setContentType("text/html;charset=utf-8");

	
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	
	request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
