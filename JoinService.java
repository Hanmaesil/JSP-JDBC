package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.S_MemberDAO;
import com.smhrd.model.S_MemberDTO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//한글 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//아이디, 패스워드, 닉네임을 변수에 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		
		//dao객체 생성
		S_MemberDAO dao = new S_MemberDAO();
		//dto 객체 생성
		//방법 1 : 객체를 만들고 매개변수에 넣어준다
		//S_MemberDTO member = new S_MemberDTO(id, pw, nick);
		//dao.memberJoin(member); //dto를 넣어야 한다.
		//방법 2 : 매개변수에 바로 선언해준다
		int cnt = dao.memberJoin(new S_MemberDTO(id, pw, nick)); //dao에있는 메소드의 매개변수 member에 값이 들어간다.
		
		if(cnt>0) {
			response.sendRedirect("joinTrue.jsp");
		}else {
			response.sendRedirect("joinFalse.jsp");
		}
	
		
		
		
	
	}

}
