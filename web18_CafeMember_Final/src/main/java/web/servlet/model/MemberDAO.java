package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberDAO {
	// 공통적인 로직 템플릿
	Connection getConnect() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException;
	void closeAll(ResultSet rs,PreparedStatement ps, Connection conn)throws SQLException;
	
	//비지니스 로직 템플릿
	void registerMember(Member vo) throws SQLException;
	ArrayList<Member> showAllMember() throws SQLException;
	Member findByIdMember(String id) throws SQLException;
	Member login(String id, String password)throws SQLException;
	
	//update 추가
	void updateMember(Member vo) throws SQLException;
	
	//idExist 추가
	boolean idExist(String id) throws SQLException;
}






