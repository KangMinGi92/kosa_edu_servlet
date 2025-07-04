package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindController implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response) {
		/*
		  MVC... Servlet... 
		  FrontController.....find(){}
		  1. 폼값 받아서
		  2. DAO 반환 비지니스 로직 호출...
		  3. 데이터 바인딩
		  4. 네비게이션
		 */
		System.out.println("FindController...DAO...findMember call...");
		return "find_ok.jsp";
	}

}
