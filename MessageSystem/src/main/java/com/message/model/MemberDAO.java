package com.message.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MemberDAO {
	
	//db연결
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private int cnt;
	private String sql;
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// 예외처리로 오류가 뜨는경우!
			// 1. OracleDriver 클래스가 해당위체 없는 경우(ojdbc6.jar 가 폴더에 없는경우)
			// 해결방안 : WEB-INF 폴더 - lib폴더 안에 ojdbc6.jar 저장!
			// 2. OracleDriver 경로가 오타인 경우
			e.printStackTrace();
		} catch (SQLException e) {
			// 예외처리로 오류가 뜨는경우!
			// DB연결 정보가 정확하지 않을 경우
			e.printStackTrace();
		}

	}

	// DB연결종료
	// 역순으로 닫아준다!
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 회원가입기능
	public int memberJoin(MemberDTO member) {
		connect();

		sql = "insert into web_member values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getM_email());
			psmt.setString(2, member.getM_pw());
			psmt.setString(3, member.getM_tel());
			psmt.setString(4, member.getM_address());

		cnt = psmt.executeUpdate();

		} catch (SQLException e) { // 예외처리가 발생해서 catch에서 걸리면 close까지 가지 않기 때문에 finally를 넣어서 무조건 마지막으로 가게한다.
			//예외처리 발생되는 경우!
			//1. SQL문장이 잘못 작성되었을 경우
			//2. psmt객체로 잘못된 인덱스 값을 작성했을 경우
			//3. 테이블이 없는 경우
			e.printStackTrace();
		}
		finally { //try -catch 문이 실행된 후 반드시 실행하기 위한 finally
		close();
		}
		
		return cnt; //회원가입이 되면 0이 아닌값이 리턴이 된다.
	}
	
	//로그인 기능
	
	public String login(String email, String pw) {
		connect();
		String result = null;
		
		
		try {
			
			sql = "select * from web_member where m_email = ? and m_pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
			}else {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	}

	

	public MemberDTO memberLogin(String email, String pw) {
		connect();
		
		
		MemberDTO member = null;
		
		
		try {
			sql = "select m_tel, m_address from web_member where m_email = ? and m_pw = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, email);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) { //회원가입된 정보가 db에 있는경우
				member = new MemberDTO(email, null, rs.getString(1), rs.getString(2)); //1,2번은 쿼리 이름(tel,address)
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		
		
		return member;
	}

	public int memberUpdate(MemberDTO memberDTO) {
		connect();
		MemberDTO member = null;
		
		
		try {
			sql = "update web_member set m_pw = ?, m_tel= ?, m_address = ? where m_email = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, memberDTO.getM_pw());
			psmt.setString(2, memberDTO.getM_tel());
			psmt.setString(3, memberDTO.getM_address());
			psmt.setString(4, memberDTO.getM_email());
			
			cnt = psmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
		
		return cnt;
	}
	//관리자모드에서 회원 정보 보기
	public ArrayList<MemberDTO> memberselectAll() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); 
		connect();
		
		
		try {
			sql = "select m_email, m_tel, m_address from web_member";
			psmt = conn.prepareStatement(sql);
			
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				//rs객체 내 저장된 회원정보들을 접근 -> Member객체 생성 -> list에 저장
				String email = rs.getString(1);
				String tel = rs.getString(2);
				String address = rs.getString(3);
				
				if(!email.equals("admin")) { //관리자 계정은 제외하고 저장
					MemberDTO member = new MemberDTO(email, null, tel, address);
					list.add(member);
				}
				
//				MemberDTO member = new MemberDTO(email, null, tel, address);
//				list.add(member);
				//이런식으로도 가능
				//list.add(new MemberDTO(email, null, tel, address));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		
		
		
		return list;
	}

	
	
	
	
	
	
	
}
