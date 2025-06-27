/*	Servlet.class가 실행되는 순서
 	1.DD파일(web.xml)파일을읽어온다.
 	2. 생성자 호출 주문서에 등록된 <servlet-name>이름</servlet-name>으로 서블릿객체를 생성
 	3. 클라이언트 요청이 들어오면 Thread생성(==service() call) 요청을 수행 *(요청 1개당 Thread 1개 생성 요청응답 후 Thread Death)
 	
 */
package web.generic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyGenericServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		/*
		 *  request안 요청 정보를 바탕으로
		 *  요청을 실행한 후 
		 *  response안에 결과를 담아서
		 *  클라이언트에게 정보를 전달
		 */
		
		PrintWriter out=response.getWriter();
		out.println("<html><body><h2>");
		out.println("Hello MyServlet~~~!!!");
		out.println("</h2></body></html>");
	}

}
