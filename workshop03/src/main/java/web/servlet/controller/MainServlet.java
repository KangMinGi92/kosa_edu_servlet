package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Product;
import web.servlet.model.ProductDAOImpl;

@WebServlet(urlPatterns = {"/MainServlet"}, loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성...
		/*
		  	1. 폼값 받아서
		  		Product 객체 생성...pvo
		  	2. DAO리턴받고
		  	3. 비지니스로직 호출(registerProduct(pvo)).. 이때 정보를 인자값으로 입력
		  	(4. 바인딩)
		  	5. 네비게이션
		  		forward......
		 */
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		int price=Integer.parseInt(request.getParameter("price"));
		String detail=request.getParameter("detail");
		
		//pvo생성
		Product pvo = new Product(name,price,detail);
		
		try {
			//쿼리문이 정상적으로 실행된다면 이 부분이 가동
			ProductDAOImpl.getInstance().addProduct(pvo);
		}catch(SQLException e) {
			//쿼리문이 비정상적으로 실행되면 이 부분이 가동
		}
		//5. result.jsp
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		
	}
}
