package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

@WebServlet(urlPatterns = { "/book/BookServlet" }, loadOnStartup = 2)
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 결과 페이지는 book/bookSuccess.jsp로
	// 에러가 나면 error/error.html로
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("utf-8");
		
		//bookNos배열 정리
		String[] bookNos = request.getParameterValues("bookNo");
		String bookNo = String.join("-", bookNos);
		
		Book book = new Book(bookNo, request.getParameter("bookTitle"), 
				request.getParameter("bookCategory"),
				request.getParameter("bookCountry"), request.getParameter("bookDate"),
				request.getParameter("bookPublisher"), request.getParameter("bookAuthor"),
				Integer.parseInt(request.getParameter("bookPrice")),request.getParameter("bookSummary"));

		try {
			BookDAOImpl.getInstance().registerBook(book);
			request.getRequestDispatcher("bookSuccess.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("../error/bookError.html");
		}

	}
}
