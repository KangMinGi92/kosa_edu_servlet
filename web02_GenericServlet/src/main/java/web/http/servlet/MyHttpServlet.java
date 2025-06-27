package web.http.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
  Annotation
  web.xml에 서블릿 등록기록이 없어도 된다.
  WAS가 Annotation을 읽어서 직접 web.xml을 만들어준다.
  
  서버내부이름 매핑
  <servlet>
  	<servlet-name>MyHttpServlet</servlet-name>
  	<servlet-class>web.http.servlet</servlet-class>
  </servlet>
  
  클라이언트 매핑
  <servlet-mapping>
  	<servlet-name>MyHttpServlet</servlet-name>
  	<url-pattern>/MyServlet</url-pattern>
  </servlet-mapping>
 */
@WebServlet("/MyServlet")
public class MyHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><body bgcolor=yellow><h2>");
		out.println("Hello MyHttpServlet~~~!!!");
		out.println("</h2></body></html>");
		
	}
	
}
