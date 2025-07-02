package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.User;
import servlet.model.UserDAOImpl;

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
		
//		String path = "loginError.jsp";
		
		/*
		 * if(id.equalsIgnoreCase("kosa")&&pass.equals("1234")) {
		 * request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		 * }else { request.getRequestDispatcher("loginError.jsp").forward(request,
		 * response); }
		 */
//		if(id.equalsIgnoreCase("kosa")&&pass.equals("1234"))
//			path = "loginSuccess.jsp";
		try {
			User user=UserDAOImpl.getInstance().login(id, pass);
			if(user !=null) { //로그인 정상적으로 성공
				request.setAttribute("user", user);
				request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			}else {//로그인 실패 
				//로그인 실패는 data를 가지고 넘어가는게 아니기 때문에 서버상이동이 아닌 html이동으로 가야한다.
				response.sendRedirect("./error/error.html"); 
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
