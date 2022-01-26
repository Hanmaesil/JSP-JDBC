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
		//�̸���, �н�����, ��ȣ, �ּҸ� �������ÿ�
		
		request.setCharacterEncoding("utf-8");
		
		
		
		String email = request.getParameter("email");
		String pw =  request.getParameter("pw");
		String tel = request.getParameter("tel");
		String add = request.getParameter("address");
		
		//dao��ü ����
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberJoin(new MemberDTO(email, pw, tel, add));
		
		if(cnt > 0) { //ȸ������ �������� �� -> join_success.jsp�� �̵�(emal��������)
			request.setAttribute("success_data", email);
			//forward ������� ������ �̵�
			RequestDispatcher dispatcher = request.getRequestDispatcher("join_success.jsp");
			dispatcher.forward(request, response);
		}else {
			response.setContentType("text/html; charset = utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('ȸ������ ����...!');"); //alert : �߰��� ���� â�� ����ش�
			out.print("location.href = 'main.jsp';"); // Ȯ��Ű ������ �̵��ϴ� ���(��,�ܺ� ���� ����)
			out.print("</script>");
		}
		
		
		
	}

}
