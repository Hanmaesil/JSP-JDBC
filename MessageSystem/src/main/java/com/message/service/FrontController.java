package com.message.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.message.model.MemberDAO;
import com.message.model.MemberDTO;

@WebServlet("*.do") // ����ΰ� �� ���ü� �ְ� �ؾ��Ѵ�!(Ȯ���ڸ� ����)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, iCommand> map; // key �� value������ �����Ǿ��ִ�.
	
	
	@Override
	public void init() throws ServletException {
		//������ ������ �� Ư�������� �ʱ�ȭ ���ִ� �޼ҵ�
		map = new HashMap<String, iCommand>(); //icomand ���¸� �����߱� ������ ��ü ���� ����(ex -> LoginCon�� iConmand�� �����޾ұ� ������ ����!)
		//iComand login = new LoginCon(); -> �������̽��� ���������� ��ü������ �Ұ��������� ������ �� Ŭ���������� �����ϴ�!
		map.put("/LoginCon.do", new LoginCon()); //map�� �̸� �����س���
		map.put("/JoinCon.do", new JoinCon());
	}
	
	
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ������� ��û�� �ѱ������� ó�����ش�!
//		System.out.println("������û...");

		// uri : conexttPath + �����н�
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()); // uri���� ���ؽ�Ʈ �н��� �����ϸ� � ���Ͽ��� ��û���� �� �� �ִ�

//		System.out.println(requestURI);
//		System.out.println(contextPath);
		System.out.println("���� ��û : " + command);
		
		// "/Login.do" ��û�� ������ ��  
		//iCommand com = mpa.get("/LoginCon.do")
		//iCommand com = new LoginCon();
		iCommand com = map.get(command); //key ���� �Է��Ͽ� value�� �����´�.
		com.execute(request, response);
		
		

//		//---------------------------------
//		request.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html; charset = utf-8");
//		//---------------------------------------
//		String email = request.getParameter("email");
//		String pw = request.getParameter("pw");
//		String tel = request.getParameter("tel");
//		String add = request.getParameter("address");
//		//--------------------------------
//		MemberDAO dao = new MemberDAO();

		
//		if (command.equals("/LoginCon.do")) {
//			// �α��� ó��
////			request.setCharacterEncoding("utf-8");
////
////			// dao���� main���� dtoŸ������ ���Ϲޱ� ���ؼ� �����
////			MemberDTO member = dao.memberLogin(email, pw);
////
////			if (member != null) {
////				System.out.println("�α��� ����!");
////
////				// session ��ü ���� -> �����ϸ� ����,���� ��� ��� ��밡��
////				HttpSession session = request.getSession();
////				session.setAttribute("member", member);
////				response.sendRedirect("main.jsp");
////
////			} else {
////				out.print("<script>");
////				out.print("alert('�α��� ����...!');"); // alert : �߰��� ���� â�� ����ش�
////				out.print("location.href = 'main.jsp';"); // Ȯ��Ű ������ �̵��ϴ� ���(��,�ܺ� ���� ����)
////				out.print("</script>");
////			}
//			
//			
//			//��ü����
//			LoginCon login = new LoginCon();
//			login.execute(request, response);
//			
//		} else if (command.equals("/JoinCon.do")) {
//			// ȸ������ ó��
//			JoinCon join = new JoinCon();
//			join.execute(request, response);
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
