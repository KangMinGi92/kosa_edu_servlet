package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

@WebServlet(urlPatterns = {"/book/AllBookServlet"})
public class AllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Book> list=BookDAOImpl.getInstance().showAllBook();
			if(list!=null) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("showAll.jsp").forward(request, response);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			response.sendRedirect("../error/bookError.html");
		}
	}
}
