package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/LifeCycleServlet"}, loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycleServlet() {
    	System.out.println("LifeCycleServlet() is called!!");
    }

	public void init() throws ServletException {
		System.out.println("init() is called!!");
	}

	public void destroy() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("doGet() is called!!");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>안녕하세요, LifeCycleServlet 입니다.</h2>");
		out.println("</body></html>");
	}

}
