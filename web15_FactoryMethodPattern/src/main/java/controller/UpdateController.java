package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateController implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response) {
		/*
		  MVC... Servlet... 
		  FrontController.....update(){}
		  1. 폼값 받아서
		  2. DAO 반환 비지니스 로직 호출...
		  3. 데이터 바인딩
		  4. 네비게이션
		 */
		System.out.println("UpdateController...DAO...updateMember call...");
		return "update_result.jsp";
	}

}
