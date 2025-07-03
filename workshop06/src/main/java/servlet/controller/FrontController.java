package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookDAOImpl;
import servlet.model.User;
import servlet.model.UserDAOImpl;

@WebServlet(urlPatterns = {"/Front","/book/Front"}, loadOnStartup = 1)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command=request.getParameter("command");
		String path="login.html";
//		if(command.equals("login")) {
//			path = login(request,response);
//		}else if(command.equals("bookRegister")) {
//			path = bookRegister(request,response);
//		}else if(command.equals("showAllBook")) {
//			path = showAllBook(request,response);
//		}
//		request.getRequestDispatcher(path).forward(request, response);
		switch(command) {
			case "login" : path = login(request,response); break;
			case "bookRegister" : path = bookRegister(request,response); break;
			case "showAllBook" : path = showAllBook(request,response); break;
			default : break;
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private String showAllBook(HttpServletRequest request, HttpServletResponse response) {
		String path="book.html";
		try {
			ArrayList<Book> list=BookDAOImpl.getInstance().showAllBook();
			if(list!=null) {
				request.setAttribute("list", list);
				path="showAll.jsp";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			path="./error/error.html";
		}
		return path;
	}

	private String bookRegister(HttpServletRequest request, HttpServletResponse response) {
		String path="book.html";
		String[] bookNos = request.getParameterValues("bookNo");
		String bookNo = String.join("-", bookNos);
		Book book = new Book(bookNo, request.getParameter("bookTitle"), 
				request.getParameter("bookCategory"),
				request.getParameter("bookCountry"), request.getParameter("bookDate"),
				request.getParameter("bookPublisher"), request.getParameter("bookAuthor"),
				Integer.parseInt(request.getParameter("bookPrice")),request.getParameter("bookSummary"));

		try {
			BookDAOImpl.getInstance().registerBook(book);
			path="bookSuccess.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			path="./error/error.html";
		}
		return path;
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String path="login.html";
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		try {
			User user=UserDAOImpl.getInstance().login(id, pass);
			if(user !=null) { //로그인 정상적으로 성공
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				path="loginSuccess.jsp";
				
			}else {//로그인 실패 
				//로그인 실패는 data를 가지고 넘어가는게 아니기 때문에 서버상이동이 아닌 html이동으로 가야한다.
				path="./error/error.html";
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return path;
	}
}
