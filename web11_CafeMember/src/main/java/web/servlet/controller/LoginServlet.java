package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 폼값 받아서 
		 * 2. try{ DAO리턴 받아서 비지니스 로직 호출 }catch 
		 * 3. Member반환.. 이걸 Session에 바인딩
		 * 4. 네비게이션 login_result.jsp
		 */
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String path = "index.html";
		try {
			Member member = MemberDAOImpl.getInstance().login(id, pass);
			if(member!=null) {
				request.getSession().setAttribute("vo", member);
				path = "login_result.jsp";
			}
		} catch (SQLException e) {
			
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
