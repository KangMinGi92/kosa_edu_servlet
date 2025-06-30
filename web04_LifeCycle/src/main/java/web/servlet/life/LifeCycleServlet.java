package web.servlet.life;
/*
 	Lazy Loading
 	Ready on상태 작업들이(서블릿 인스턴스 생성, 서블릿 초기화..)
 	최초의 클라이언트가 서버에 서비스를 요청하기 전에 이미 서버에서 진행된다.
 	
 	Pre Loading
 	Ready On 상태 작업들이
 	클라이언트가 서비스를 요청하기 전에 이미 완료된 상태로 서비스를 맞게된다.
 	이렇게 작업이 미리 되어있기 위해서는 중요한 옵션을 Annotation에 지정
 	<load-on-startup> 1 </load-on-startup> ==> web.xml에 추가할때
 	@WebServlet(urlPatterns = {"/Life"}, loadOnStartup = 1) ==> Annotation에 추가할때
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Pre Loading 방식
//Client가 서비스를 요청하기 전에 ready on 작업이 먼저 진행되어야한다.

//Lazy Loading 방식으로 WAS가 구성되어있다.
//그래서 Client가 최초서비스를 요청 할때 ready on작업이 함께 진행된다.

@WebServlet(urlPatterns = {"/Life"}, loadOnStartup = 1) //loadOnStartup 1은 Pre Loading방식으로 하겠다 선언 디폴트는 Lazy Loading
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//필드 추가
	private int count=0;
    
    public LifeCycleServlet() {
    	System.out.println("1. 서블릿 인스턴스 생성...LifeCycleServlet()호출 .. by container");
    }
    
	public void init() throws ServletException {
		System.out.println("2. init() 호출.. by container");
	}

	public void destroy() {
		System.out.println("4. destroy() 호출.. by container");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. doget() 호출.. by container");
		//클라이언트 쪽으로 응답
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=yellow>");
		out.println("<h3>LifeCycle CallBack Method...</h3>");
		out.println("<b>Count :: "+ ++count + "</b>");
		out.println("</body></html>");
		
		out.close();
	}

}
