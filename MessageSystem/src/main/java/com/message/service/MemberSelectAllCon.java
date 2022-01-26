package com.message.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.message.model.MemberDAO;
import com.message.model.MemberDTO;

@WebServlet("/MemberSelectAllCon")
public class MemberSelectAllCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> members = dao.memberselectAll();
		
		//��üŸ���� �����ϱ� ���ؼ� forward����� ���!
		request.setAttribute("members", members);
		
		//members��� ��ü������ select.jsp�� �����ϱ� ���ؼ� forward����� Ȱ��!
		//why? redirect ����� �ؽ�Ʈ �����͸� ������ �����ϱ� �����̴�!
		
		//�ڡڡڡڡڡڡ� session�� ������� �ʰ�  request�� ����ϴ� ������? �ڡڡڡڡڡڡڡ�
 		// -> ȸ������ ������ select.jsp������ ����� ���̱� ������ request������ ������ �ϴ� ���̴�!
		// -> session�� �����ϸ� �������� ����Ǳ� ������ �����Ǳ� ������ ������� �ʴ´�! 
		RequestDispatcher dispatcher = request.getRequestDispatcher("select.jsp");
		dispatcher.forward(request, response);
		
	}

}
