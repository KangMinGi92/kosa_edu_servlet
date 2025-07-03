package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직작성
		HttpSession session = request.getSession();//기존의 세션을 사용
		if(session.getAttribute("vo") !=null) { //로그인 된 상태라면
			
			System.out.println("BuyServlet JSESSION=>"+session.getId());
			session.setAttribute("pvo","Wide TV");
			
			
			//네비게이션...? buy.jsp
			request.getRequestDispatcher("buy.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.html");
		}
	}
}
