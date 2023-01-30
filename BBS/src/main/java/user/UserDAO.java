package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	// Connection이란 DB에 접근하게 해주는 하나의 객체를 의미
	private Connection conn;
	private PreparedStatement pstmt;
	// 어떠한 정보를 담을 수 있는 하나의 객체
	private ResultSet rs;
	
	// 생성자를 만듦
	// 자동으로 DB 커넥션이 이루어지도록 함
	// try catch로 오류를 처리할 수 있도록 함 
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID = "root";
			String dbPassword ="root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//실제로 로그인을 시도하는 login 함수를 만듦
	public int login(String userID, String userPassword) {
		// 삽입할 SQL문
		String SQL = "select userPassword From USER where userID = ? ";
		try {
			//정해진 SQL문을 DB에 삽입
			
		}
				
	}
	
	
	
}
