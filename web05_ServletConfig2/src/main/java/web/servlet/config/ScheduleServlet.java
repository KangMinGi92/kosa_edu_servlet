package web.servlet.config;
/*
 	페이지 이동 방법
 	1.forward 90% 이동방식
 		서버상에서 다이렉트로 이동하는 방식
 		단순 검색기능일때 반드시 이 방식으로 이동!
 		request.getRequestDispatcher("page").forward(req,res);
 	2.redirect
 		헤더의 페이지방향을 바꾼다.
 		로그인 후 메인페이지로 이동!
 		response.sendRedirect("page");
 	두방식의 차이점
 	1. 요청, 응답수
 	2. 사용가능한 Attribute
 	3. 주소창 변경여부
 	4. 다른서버의 컴포넌트 접근여부(redirect는 요청에 응답을해서 다음 요청을 http가 보내기때문에 같은서버 이외의 서버로 접근가능하다.)
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Schedule")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성..
		String today=request.getParameter("today");
		PrintWriter out=response.getWriter();
		out.println("<html><body><h3>");
		out.println("Today is "+today+"<br>");
		out.println("Football, Swimming...");
		out.println("</h3></body></html>");
		
	}
}
