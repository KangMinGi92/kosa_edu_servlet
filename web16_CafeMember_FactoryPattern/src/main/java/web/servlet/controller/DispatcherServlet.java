package web.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//확장자가 .do로 들어오는 모든 요청은
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	/*
	 * 이전 방식과는 다른 방식으로 command값을 받아보자 hidden태그 방식이 아닌 들어온 요청을 직접 받아서 command값으로 연결.
	 */
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();// web16_CafeMember_FactoryPattern/find.do
		System.out.println("getReqestURI() => " + requestURI);

		String contextPath = req.getContextPath();// web16_CafeMember_FactoryPattern
		System.out.println("getContextPath() => " + contextPath);

		String command = requestURI.substring(contextPath.length() + 1);
		System.out.println("command => " + command);// find.do

		// 1. commmand값을 주고 Controller를 반환
		Controller controller = HandlerMapping.getInstance().createController(command);
		ModelAndView mv = null;
		String path = "index.jsp";
		// 2. Controller의 기능을 호출... FindController가 실행...ModelAndView를 반환
		try {
			mv = controller.handleRequest(req, resp);
			if (mv != null) {
				path = mv.getPath();
				if (mv.isRedirect())
					resp.sendRedirect(path);
				else
					req.getRequestDispatcher(path).forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
