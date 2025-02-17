package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 회원 등록 폼을 전송할 서블릿 만들기

// HttpServlet 클래스를 상속받고, 서브릿 이름과 URL 설정
@WebServlet(name = "FormServlet", urlPatterns = "/servlet/form")
public class FormServlet  extends HttpServlet{

	// 1. HttpServlet을 상속받는다.
	// 2. service 함수를 재정의하여 사용자 요청을 처리한다.
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 응답 메세지 설정(컨텐츠 타입과 문자 인코딩)
		resp.setContentType("text/html");	// HTML, JSON, XML ...
		resp.setCharacterEncoding("utf-8");
		
		// 응답 데이터를 작성하기 위해 writer 객체 생성
		PrintWriter w = resp.getWriter();
		
		// 회원 정보를 입력할 수 있는 html form 태그를 만들어서 응답에 추가
		// 자바코드로 html을 작성해야 해서 힘들다.. 이부분은 실습코드에서 복사할 것!
		w.write("<!DOCTYPE html>\n" +
		"<html>\n" +
		"<head>\n" +
		" <meta charset=\"UTF-8\">\n" +
		" <title>회원 등록</title>\n" +
		"</head>\n" +
		"<body>\n" +
		"<form action=\"/servlet/save\" method=\"post\">\n" + // 폼을 전송할 주소
		" 이름: <input type=\"text\" name=\"username\" />\n" + // 이름 입력 필드
		" 암호: <input type=\"text\" name=\"password\" />\n" + // 패스워드 입력 필드
		" <button type=\"submit\">전송</button>\n" + // 전송 버튼
		"</form>\n" +
		"</body>\n" +
		"</html>\n");
	}

	
	
}
