package web.generic.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
 	Servlet(web.xml없이 만들었을때) 작동순서
 	1. DD파일을 읽는다. x -> @WebServlet("/MGS") 어노테이션을 읽는다.
 */
/*
  Annotation
  일종의 마킹
  xml코드를 줄이거나 대체
  
 */

/*
 	@WebServlet("/MGS") 이 한줄이 web.xml 에 적은 8줄을 대체한다.
 	<!-- 1. 서버내부이름 매핑  -->
	<servlet>
		<servlet-name>MyGenericServlet</servlet-name><!--아래 주소값을 name태그로 매핑  -->
		<servlet-class>web.generic.servlet.MyGenericServlet</servlet-class> <!--서버내부이름  -->
	</servlet>
	
	<!-- 2. 클라이언트 매핑  -->
	<servlet-mapping>
		<servlet-name>MyGenericServlet</servlet-name>
		<url-pattern>/MGS</url-pattern> <!--클라이언트(Front)단에서 요청한 주소값을 servlet-name MGS로 매핑  -->
	</servlet-mapping>
*/
@WebServlet("/MGS")
public class MyServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><body><h2>");
		out.println("Hello MyServlet~~~!!!");
		out.println("</h2></body></html>");
		
	}

}
