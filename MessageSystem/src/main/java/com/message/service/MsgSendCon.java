package com.message.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.message.model.MemberDTO;
import com.message.model.MessageDAO;
import com.message.model.MessageDTO;

@WebServlet("/MsgSendCon")
public class MsgSendCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");
		
		String name =  request.getParameter("name");
		String email = request.getParameter("email");
		String message =  request.getParameter("message");
		
		MessageDAO dao = new MessageDAO();
		int cnt = dao.msgSend(new MessageDTO(0, name, email, message, null));
		
		if(cnt > 0){
			response.sendRedirect("main.jsp");
		}else {
			response.setContentType("text/html; charset = utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('메세지 전송 실패...!');"); //alert : 중간에 작은 창을 띄어준다
			out.print("location.href = 'main.jsp';"); // 확인키 누르면 이동하는 장소(내,외부 전부 가능)
			out.print("</script>");
		}
	
		
		
		
	
	}

}
