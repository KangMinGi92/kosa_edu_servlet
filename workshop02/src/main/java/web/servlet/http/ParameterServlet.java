package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/params"}, loadOnStartup = 1)
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//양방향 한글처리
		response.setContentType("text/html;charset=utf-8");
		
		//폼값 받아서
		String job=request.getParameter("job");
		String pageNo=request.getParameter("pageNo");
		String searchWord=request.getParameter("searchWord");
		//브라우저로 출력
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>job : "+job+"</h3>");
		out.println("<h3>pageNo : "+pageNo+"</h3>");
		out.println("<h3>searchWord : "+searchWord+"</h3>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//양방향 한글처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//폼값 받아서
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String[] hobbies=request.getParameterValues("hobby");
		String favorite=request.getParameter("favorite");
		String desc=request.getParameter("desc");
		String hobby="";
		
		//브라우저로 출력
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>name : "+name+"</h3>");
		out.println("<h3>email : "+email+"</h3>");
		out.println("<h3>gender : "+gender+"</h3>");
		for(String s : hobbies) {
			hobby += s+",";
		}
		out.println("<h3>hobby : "+hobby+"</h3>");
		out.println("<h3>favorite : "+favorite+"</h3>");
		out.println("<h3>favdescorite : "+desc+"</h3>");
		out.println("</body></html>");
		
	}

}
