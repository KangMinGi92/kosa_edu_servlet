package web.servlet.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.MemberDAOImpl;

public class IdExistController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 폼값 가져오기
		String id = request.getParameter("id");
		try {
			boolean flag = MemberDAOImpl.getInstance().idExist(id);

			request.setAttribute("flag", flag);
			request.getRequestDispatcher("result.jsp").forward(request, response);

			/*
			 * PrintWriter out = response.getWriter(); 
			 * out.print(flag);
			 */
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

}
