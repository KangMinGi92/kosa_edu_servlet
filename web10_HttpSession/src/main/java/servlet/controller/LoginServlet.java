package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Member;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	  1. 폼값 받아서
	  2. pvo생성
	  3. DAO리턴받고 비지니스로직 호출
	  4. 반환되는 값을 바인딩...
	  5. 세션에 바인딩
	  	 로그인, 회원정보 수정때만
	  6. 네비게이션
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//디비연결후 반환값
		Member pvo = new Member(id,password,"홍종각","종각");
		
		HttpSession session=request.getSession();//맨 처음 만들어진 세션
		System.out.println("LoginServlet...JSESSION =>"+session.getId());
		
		session.setAttribute("vo", pvo); //로그인 정보를 바인딩
		
		//네비게이션......?
		
		response.sendRedirect("BuyServlet");
		
	}

}
