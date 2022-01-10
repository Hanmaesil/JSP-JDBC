package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionSelect")
public class SessionSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//서블릿에서 세션 활용
		//HttpSession 라는 인터페이스 import를 해야지 세션을 사용할 수 있다.
		HttpSession session = request.getSession();
		
		//다운캐스팅
		String msg = (String)session.getAttribute("msg");
		
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head></head><body>");
		out.print(msg);
		out.print("</body></html>");
		
	}

}
