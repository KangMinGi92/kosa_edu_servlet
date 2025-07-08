package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;
//자바클래스 ... Componenet
public class FindController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 	MVC -->FindServlet
		 	FronController --> find()
		 */
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		try {
			Member rvo=MemberDAOImpl.getInstance().findByIdMember(id);
			if(rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
		}catch(SQLException e) {
			
		}
		return new ModelAndView(path);
	}

}
