package servlet.model;

/*
 	1. 싱글톤
 	2. 생성자에서 JNDI서비스로 DataSource 받아옴(context.xml)
 	3. 공통로직 구현
 	4. login 구현... 단위테스트
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class UserDAOImpl implements UserDAO {
	private static UserDAOImpl dao = new UserDAOImpl();
	DataSource ds =null;
	
	public static UserDAOImpl getInstance() {
		return dao;
	}
	
	public UserDAOImpl() {
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
	public Connection getConnection()throws SQLException{
		return ds.getConnection();
	};

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
	public User login(String userId, String password) throws SQLException {
		User user=null;
		Connection conn=getConnection();
		String query="SELECT userId, password, name, email FROM userinfo WHERE userId=? AND password=?";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1,userId);
		ps.setString(2,password);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			user = new User(userId,password,rs.getString("name"),rs.getString("email"));
		return user;
	}
	
	public static void main(String[] args) {
		UserDAOImpl dao=getInstance();
		try {
			dao.login(null, null);
		}catch(SQLException e) {
			
		}
	}
}
