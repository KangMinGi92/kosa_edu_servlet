package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

@WebServlet(urlPatterns = {"/Front"},loadOnStartup = 1)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기다 작성
		String command = request.getParameter("command");
		String path = "index.html";
		
		if(command.equals("find")) {//회원검색요청이 들어왔다면,
			path=find(request,response);
		}else if(command.equals("register")) {//회원등록 요청이 들어왔다면,
			path=register(request,response);
		}else if(command.equals("login")) {//로그인 요청이 들어왔다면,
			path=login(request,response);
		}else if(command.equals("allMember")) {//전체 검색 요청이 들어왔다면,
			path=allMember(request,response);
		}
		request.getRequestDispatcher(path).forward(request, response);
}


	////////////////////////////////////////////////////////////////////////////////////////
	private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
		return path;
	}
	
	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String address = request.getParameter("address").trim();
		Member pvo =null;
		String path = "index.html";	
		
		if(name.equals("") || address.equals("")) {
			 pvo = new Member(id, password);
		}else {
			pvo = new Member(id, password, name, address);
		}			
		
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "register_result.jsp";
		}catch(SQLException e) {
			System.out.println(e);
		}
		return path;
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) {
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
		return path;
	}
	
	private String allMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path="index.html";
		try {
			ArrayList<Member> list=MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			path="allView.jsp";
		}catch(SQLException e) {
			
		}
		return path;
	}
}
