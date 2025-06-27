package web.servlet.form;

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
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 	1. 폼값 받아온다.
		 	2. 그 값을 그대로 화면에 출력
		 */
		//한글처리는 request, response 각각 따로 처리해야 한다.
		response.setContentType("text/html;charset=utf-8");
		//여기서 request.setContentType("text/html;charset=utf-8"); 안해줘도 되는이유는 server.xml에 doget방식으로 불러올때 이미
		//한글 인코딩 (utf-8)을 선언해둬서 안해줘도 한글처리가 된다. 단, post사용시에는 까먹지말고 인코딩 처리 해야한다.
		
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		
		/*
		결과 페이지의 역할은 Servlet 역할이 아니다.
		Servlet 로직 중심의 기술이고
		Tag중심의 기술 JSP 에서 담당하도록 한다.
		
		PrintWriter out=response.getWriter();
		//response.setContentType("text/html;charset=utf-8"); 한글처리는 request,response 사용전 미리 세팅해야해서 최상단에 선언한다.
		
		out.println("<html><body>"); 
		out.println("<h2>당신의 이름은 "+name+"</h2>");
		out.println("<h2>당신이 사는곳은 "+addr+"</h2>");
		out.println("</body></html>");
		*/
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
