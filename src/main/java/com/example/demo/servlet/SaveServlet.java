package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveServlet" , urlPatterns = "/servlet/save")
public class SaveServlet extends HttpServlet {

	MemberRepository repository = new MemberRepository();  
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 요청 메세지에서 사용자가 전달한 파라미터를 조회
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// 회원 이름과 패스워드로 새로운 멤버 객체 생성
		Member member = new Member(0, username, password);
		
		// 생성된 회원 객체를 저장소에 등록
		repository.save(member);
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter w = resp.getWriter();
		
		// 등록 결과를 확인하기 위한 html을 만들어서 응답에 추가
        // 자바코드로 html을 작성해야 해서 힘들다.. 이부분도 실습코드에서 복사할 것!
        w.write("<html>\n" +
        "<head>\n" +
        " <meta charset=\"UTF-8\">\n" +
        "</head>\n" +
        "<body>\n" +
        "성공\n" +
        "<ul>\n" +
        " <li>회원번호="+member.getNo()+"</li>\n" +
        " <li>이름="+member.getUserId()+"</li>\n" +
        " <li>비밀번호="+member.getPassword()+"</li>\n" +
        "</ul>\n" +
        "</body>\n" +
        "</html>");
	
		
	}
	
}
