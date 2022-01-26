package com.message.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.message.model.MemberDAO;
import com.message.model.MemberDTO;

@WebServlet("/JoinCon")
public class JoinCon implements iCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//이메일, 패스워드, 번호, 주소를 가져오시오
		
		request.setCharacterEncoding("utf-8");
		
		
		
		String email = request.getParameter("email");
		String pw =  request.getParameter("pw");
		String tel = request.getParameter("tel");
		String add = request.getParameter("address");
		
		//dao객체 생성
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberJoin(new MemberDTO(email, pw, tel, add));
		
		if(cnt > 0) { //회원가입 성공했을 때 -> join_success.jsp로 이동(emal정보전달)
			request.setAttribute("success_data", email);
			//forward 방식으로 페이지 이동
			RequestDispatcher dispatcher = request.getRequestDispatcher("join_success.jsp");
			dispatcher.forward(request, response);
		}else {
			response.setContentType("text/html; charset = utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('회원가입 실패...!');"); //alert : 중간에 작은 창을 띄어준다
			out.print("location.href = 'main.jsp';"); // 확인키 누르면 이동하는 장소(내,외부 전부 가능)
			out.print("</script>");
		}
		
		
		
	}

}
