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

@WebServlet("/UpdateCon")
public class UpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		//이메일은 회원정보수정form에서 받는게 아니기 때문에 세션에서 가져와야한다!(이메일이 db에서 업데이트할 정보를 찾는 기준)
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		
		String email = member.getM_email();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address= request.getParameter("address");
		
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.memberUpdate(new MemberDTO(email, pw, tel, address));
		
		if(cnt > 0 ) {
			session.setAttribute("member", new MemberDTO(email, pw, tel, address));
			response.sendRedirect("main.jsp");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('회원정보 수정 실패...!');"); //alert : 중간에 작은 창을 띄어준다
			out.print("location.href = 'main.jsp';"); // 확인키 누르면 이동하는 장소(내,외부 전부 가능)
			out.print("</script>");
		}
	
	
	
	
	
	
	}
	

}
