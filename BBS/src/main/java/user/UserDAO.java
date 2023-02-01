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
			String jdbcURL = "jdbc:mysql://localhost:3306/BBS?serverTimezone=Asia/Seoul";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcURL, "root", "0610");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//실제로 로그인을 시도하는 login 함수를 만듦
	public int login(String userID, String userPassword) {
		// 삽입할 SQL문
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		// 예외처리를 해줘야함
		try {
			//정해진 SQL문을 DB에 삽입
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			// 만약 담긴 정보가 있다면 실행!
			if (rs.next()) {
				if(rs.getString(1).equals(userPassword))
					return 1; // 로그인 성공
				else
					return 0; // 비밀번호 불일치
			}
			return -1; // 아이디가 없음
		} catch (Exception e ) {  
			e.printStackTrace();
		}
		return -2; // 데이터베이스 오류
				
	}
	
	
	
}
