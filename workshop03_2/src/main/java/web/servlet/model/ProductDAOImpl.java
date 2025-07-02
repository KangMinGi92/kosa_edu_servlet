package web.servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import config.ServerInfo;

public class ProductDAOImpl implements ProductDAO{
	private static ProductDAOImpl dao = new ProductDAOImpl();
	private DataSource ds=null;
	private ProductDAOImpl() {
		try {
//			Class.forName(ServerInfo.DRIVER_NAME);
			
			//JNDI 서비스 코드로 수정...
			InitialContext ic=new InitialContext();
			ds =(DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource Lookup....Success!!!");
		}catch(Exception e) {
//			System.out.println("드라이버 로딩 실패!!!..");
			System.out.println("DataSource Lookup....Fail!!!");
		}
		
	}
	public static ProductDAOImpl getInstance() {
		return dao;
	}
	//공통 로직...
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{
		if(rs!=null) rs.close();
		closeAll(ps,conn);
	}
	
	public Connection getConnect() throws SQLException{
//		Connection conn= DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASS);
		Connection conn= ds.getConnection();
		System.out.println("디비연결 성공");
		return conn;
	}
	
	//비지니스로직..
	@Override
	public void addProduct(Product vo) throws SQLException {
		Connection conn=getConnect();
		String query="INSERT INTO product(name, price, detail) VALUES(?,?,?)";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1,vo.getName());
		ps.setInt(2,vo.getPrice());
		ps.setString(3,vo.getDetail());
		System.out.println(ps.executeUpdate()+" 개 상품 등록...");
		closeAll(ps, conn);
		
	}//addProduct

	@Override
	public ArrayList<Product> getAllProduct() throws SQLException {
		ArrayList<Product> products=new ArrayList<>();
		Connection conn=getConnect();
		String query = "SELECT num,name,price,detail FROM product";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			products.add(new Product(rs.getInt("num"),rs.getString("name"),rs.getInt("price"),rs.getString("detail")));
		}
		closeAll(rs,ps,conn);
		return products;
	}
	public static void main(String[] args)throws Exception {
		ProductDAOImpl dao=ProductDAOImpl.getInstance();
//		dao.addProduct(new Product("TV",3530000,"화질이 좋아요"));
//		dao.getAllProduct().stream().forEach(System.out::println);
	}
}//class
