package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAOImpl implements BookDAO{
	public static BookDAOImpl dao=new BookDAOImpl();
	DataSource ds =null;
	
	public static BookDAOImpl getInstance() {
		return dao;
	}
	
	public BookDAOImpl() {
		try {
			Context ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource Lookup....success!!!");
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("DataSource Lookup....success!!!");
		}
	}
	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	@Override
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	@Override
	public void close(PreparedStatement ps, ResultSet rs, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	@Override
	public void registerBook(Book book) throws SQLException {
		
		Connection conn=getConnection();
		String query =
				"""
				INSERT INTO BOOK(isbn,title,catalogue,nation,publish_date,publisher,author,price,currency,description)
				VALUES(?,?,?,?,?,?,?,?,?,?)
				""";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,book.getIsbn());
		ps.setString(2,book.getTitle());
		ps.setString(3,book.getCatalogue());
		ps.setString(4,book.getNation());
		ps.setString(5,book.getPublish_date());
		ps.setString(6,book.getPublisher());
		ps.setString(7,book.getAuthor());
		ps.setInt(8,book.getPrice());
		ps.setString(9,book.getCurrency());
		ps.setString(10,book.getDescription());
		ps.executeUpdate();

		close(ps, conn);
		
	}

	@Override
	public ArrayList<Book> showAllBook() throws SQLException {
		ArrayList<Book> books=new ArrayList<>();
		Connection conn=getConnection();
		String query = 
						"""
						SELECT isbn,title,catalogue,nation,publish_date,publisher,author,price,currency,description
						FROM book
						""";
		PreparedStatement ps =conn.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				books.add(new Book(
							rs.getString("isbn"),rs.getNString("title"),rs.getString("catalogue"),
							rs.getString("nation"),rs.getString("publish_date"),rs.getString("publisher"),
							rs.getString("author"),rs.getInt("price"),rs.getString("description")
						));
			}
		}
		
		close(ps, rs, conn);
		return books;
	}
	
	
}
