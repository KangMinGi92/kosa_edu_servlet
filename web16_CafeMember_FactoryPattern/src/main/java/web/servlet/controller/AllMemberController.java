package web.servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class AllMemberController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path="index.jsp";
		try {
			ArrayList<Member> list=MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			path="allView.jsp";
		}catch(SQLException e) {
			
		}
		return new ModelAndView(path); //forward방식
	}

}
