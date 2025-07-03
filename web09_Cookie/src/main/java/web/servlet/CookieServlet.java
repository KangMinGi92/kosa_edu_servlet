package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 쿠키 생성
			Cookie c1 = new Cookie("id","kosa");
			Cookie c2 = new Cookie("today","2025-07-03");
			
		// Cookie의 유효시간을 지정할 수 있다.
		// 쿠키가 저장되는(브라우저) 시간을 지정하는 것이 된다.
		c1.setMaxAge(24 * 60 * 60); //하루동안 브라우저에 저장
		c2.setMaxAge(24 * 60 * 60 * 2);
		
		//2. 클라이언트로 보낸다.
			response.addCookie(c1);
			response.addCookie(c2);
		//3 다음번 요청때 다시 받을 것이다...(다른 서블릿이나 JSP에서 받아야한다.)
			//페이지 이동
			response.sendRedirect("result_cookie.jsp");
	}

}
