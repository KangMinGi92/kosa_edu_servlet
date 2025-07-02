package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MainServlet"}, loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 처리
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		String path = "loginError.jsp";
		
		/*
		 * if(id.equalsIgnoreCase("kosa")&&pass.equals("1234")) {
		 * request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		 * }else { request.getRequestDispatcher("loginError.jsp").forward(request,
		 * response); }
		 */
		if(id.equalsIgnoreCase("kosa")&&pass.equals("1234"))
			path = "loginSuccess.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}
}
