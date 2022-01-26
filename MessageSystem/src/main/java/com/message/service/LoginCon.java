package com.message.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.message.model.MemberDAO;
import com.message.model.MemberDTO;

//@WebServlet("/LoginCon") // 상속을 받지 않기때문에 필요없다!
public class LoginCon implements iCommand{
//	private static final long serialVersionUID = 1L; // 상속을 받지 않기때문에 필요없다!
	
	//인터페이스를 받으면서 접근제한자를 public로 바꾸고 인터페이스에 있는 메소드를 사용한다.
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		
		//dao에서 main으로  dto타입으로 리턴받기 위해서 만들기
		MemberDTO member = dao.memberLogin(email,pw);
		
		if(member!= null) {
			System.out.println("로그인 성공!");
			
			//session 객체 생성 -> 생성하면 생성,삭제 등등 기능 사용가능
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			response.sendRedirect("main_jstl.jsp");
			
		}else {
			response.setContentType("text/html; charset = utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인 실패...!');"); //alert : 중간에 작은 창을 띄어준다
			out.print("location.href = 'main_jstl.jsp';"); // 확인키 누르면 이동하는 장소(내,외부 전부 가능)
			out.print("</script>");
		}
		
		
	}

}
