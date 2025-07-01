package web.servlet.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
	
	void addProduct(Product vo)throws SQLException;
	
	ArrayList<Product> getAllProduct()throws SQLException;
}
