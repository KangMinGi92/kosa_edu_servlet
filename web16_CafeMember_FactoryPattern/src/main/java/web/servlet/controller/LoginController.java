package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String path = "index.jsp";
		try {
			Member member = MemberDAOImpl.getInstance().login(id, pass);
			if(member!=null) {
				request.getSession().setAttribute("vo", member);
				path = "login_result.jsp";
			}
		} catch (SQLException e) {
			
		}
		return new ModelAndView(path);
	}

}
