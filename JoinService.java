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
		
		//�ѱ� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		//���̵�, �н�����, �г����� ������ ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		
		//dao��ü ����
		S_MemberDAO dao = new S_MemberDAO();
		//dto ��ü ����
		//��� 1 : ��ü�� ����� �Ű������� �־��ش�
		//S_MemberDTO member = new S_MemberDTO(id, pw, nick);
		//dao.memberJoin(member); //dto�� �־�� �Ѵ�.
		//��� 2 : �Ű������� �ٷ� �������ش�
		int cnt = dao.memberJoin(new S_MemberDTO(id, pw, nick)); //dao���ִ� �޼ҵ��� �Ű����� member�� ���� ����.
		
		if(cnt>0) {
			response.sendRedirect("joinTrue.jsp");
		}else {
			response.sendRedirect("joinFalse.jsp");
		}
	
		
		
		
	
	}

}
