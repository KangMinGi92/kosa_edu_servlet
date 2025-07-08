package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션을 죽이는 로직을 작성....
		String path = "index.jsp";
		try {
			//로그인된 상태라면 세션을 죽인다.
			HttpSession session = request.getSession();
			if(session.getAttribute("vo") !=null) {
				session.invalidate();
				path="logout.jsp";
			}
		}catch(Exception e){
			
		}
		return new ModelAndView(path);
	}
	
	
}
