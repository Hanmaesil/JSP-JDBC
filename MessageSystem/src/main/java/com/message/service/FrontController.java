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

@WebServlet("*.do") // 모든경로가 다 들어올수 있게 해야한다!(확장자를 통일)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, iCommand> map; // key 와 value값으로 구성되어있다.
	
	
	@Override
	public void init() throws ServletException {
		//서버가 실행할 때 특정값들을 초기화 해주는 메소드
		map = new HashMap<String, iCommand>(); //icomand 형태를 저장했기 때문에 객체 저장 가능(ex -> LoginCon이 iConmand를 구현받았기 때문에 가능!)
		//iComand login = new LoginCon(); -> 인터페이스는 독자적으로 객체생성이 불가능하지만 구현을 한 클래스에서는 가능하다!
		map.put("/LoginCon.do", new LoginCon()); //map에 미리 저장해놓기
		map.put("/JoinCon.do", new JoinCon());
	}
	
	
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자의 요청을 한군데에서 처리해준다!
//		System.out.println("서버요청...");

		// uri : conexttPath + 서블릿패스
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()); // uri에서 컨텍스트 패스를 제외하면 어떤 파일에서 요청한지 알 수 있다

//		System.out.println(requestURI);
//		System.out.println(contextPath);
		System.out.println("들어온 요청 : " + command);
		
		// "/Login.do" 요청이 들어왔을 때  
		//iCommand com = mpa.get("/LoginCon.do")
		//iCommand com = new LoginCon();
		iCommand com = map.get(command); //key 값을 입력하여 value를 가져온다.
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
//			// 로그인 처리
////			request.setCharacterEncoding("utf-8");
////
////			// dao에서 main으로 dto타입으로 리턴받기 위해서 만들기
////			MemberDTO member = dao.memberLogin(email, pw);
////
////			if (member != null) {
////				System.out.println("로그인 성공!");
////
////				// session 객체 생성 -> 생성하면 생성,삭제 등등 기능 사용가능
////				HttpSession session = request.getSession();
////				session.setAttribute("member", member);
////				response.sendRedirect("main.jsp");
////
////			} else {
////				out.print("<script>");
////				out.print("alert('로그인 실패...!');"); // alert : 중간에 작은 창을 띄어준다
////				out.print("location.href = 'main.jsp';"); // 확인키 누르면 이동하는 장소(내,외부 전부 가능)
////				out.print("</script>");
////			}
//			
//			
//			//객체생성
//			LoginCon login = new LoginCon();
//			login.execute(request, response);
//			
//		} else if (command.equals("/JoinCon.do")) {
//			// 회원가입 처리
//			JoinCon join = new JoinCon();
//			join.execute(request, response);
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
