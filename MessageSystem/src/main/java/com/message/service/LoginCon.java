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

//@WebServlet("/LoginCon") // ����� ���� �ʱ⶧���� �ʿ����!
public class LoginCon implements iCommand{
//	private static final long serialVersionUID = 1L; // ����� ���� �ʱ⶧���� �ʿ����!
	
	//�������̽��� �����鼭 ���������ڸ� public�� �ٲٰ� �������̽��� �ִ� �޼ҵ带 ����Ѵ�.
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		
		//dao���� main����  dtoŸ������ ���Ϲޱ� ���ؼ� �����
		MemberDTO member = dao.memberLogin(email,pw);
		
		if(member!= null) {
			System.out.println("�α��� ����!");
			
			//session ��ü ���� -> �����ϸ� ����,���� ��� ��� ��밡��
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			response.sendRedirect("main_jstl.jsp");
			
		}else {
			response.setContentType("text/html; charset = utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('�α��� ����...!');"); //alert : �߰��� ���� â�� ����ش�
			out.print("location.href = 'main_jstl.jsp';"); // Ȯ��Ű ������ �̵��ϴ� ���(��,�ܺ� ���� ����)
			out.print("</script>");
		}
		
		
	}

}
