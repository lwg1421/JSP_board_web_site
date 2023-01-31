<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  우리가 만든 클래스를 사용하기위해 import -->
<%@ page import = "user.UserDAO" %>
<%@ page import = "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!-- 자바 빈을 사용한다고 알려줌 -->
<jsp:useBean id = "user" class = "user.User" scope = "page" />
<jsp:setProperty name = "user" property = "userID" />
<jsp:setProperty name = "user" property = "userPassword" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%
		// userDAO 인스턴스 생성
		UserDAO userDAO = new UserDAO();
		// 사용자가 입력한 아이디와 패스워드의 결과값(1,0, -1, -2)을 result 변수에 담아줌
		int result = userDAO.login(user.getUserID(), user.getUserPassword());
		// 로그인 성공 시(result값이 1) main.jsp로 이동하도록 스크립트 작성
		if (result == 1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'main.jsp");
			script.println("</script>");
		// 비밀번호 불일치 시 (result값이 0) 뒤로 이동하도록 스크립트 작성(history.back())
		} else if (result == 0) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");			
			script.println("</script");
		// 아이디가 존재하지 않을 시 (result값이 0) 뒤로 이동하도록 스크립트 작성(history.back())
		} else if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("history.back()");			
			script.println("</script");
		// DB에서 오류 발생 시 (result값이 0) 뒤로 이동하도록 스크립트 작성(history.back())
		} else if (result == -2) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.')");
			script.println("history.back()");			
			script.println("</script");
		}
	%>
</body>
</html>