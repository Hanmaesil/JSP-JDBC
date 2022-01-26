package com.message.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class MessageDAO {

	// db연결

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

	// 보낸 메세지 db에 저장
	public int msgSend(MessageDTO messageDTO) {
		connect();

		try {
			sql = "insert into web_message values(num_seq.nextval, ?,?,?, sysdate)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, messageDTO.getM_sendName());
			psmt.setString(2, messageDTO.getM_receivEmail());
			psmt.setString(3, messageDTO.getM_content());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;

	}

//		public ArrayList getMSG(String m_email) {
//			connect();
//			
//			try {
//				sql = "select m_sendName,m_content,m_sendDate from web_message where m_receiveEmail = ? ";
//				psmt = conn.prepareStatement(sql);
//				psmt.setString(1, m_email);
//				
//				rs = psmt.executeQuery();
//				
//				if(rs.next()){
//					ArrayList<String> content = new ArrayList<String>();
//					content.get(cnt);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			return null;
//		}
	// 메세지 불러오기
	public ArrayList<MessageDTO> messageSelect(String email) {

		ArrayList<MessageDTO> list = new ArrayList<MessageDTO>();

		connect();

		try {
			sql = "select m_num,m_sendName,m_content,m_sendDate from web_message where m_receiveEmail = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);

			rs = psmt.executeQuery();

			while (rs.next()) {

				// 변수에 담아서 추가하는 방법
				int m_num = rs.getInt(1);
				String m_sendName = rs.getString(2);
				String m_content = rs.getString(3);
				String m_sendDate = rs.getString(4);

				MessageDTO message = new MessageDTO(m_num, m_sendName, null, m_content, m_sendDate);
				list.add(message);

				// 바로 추가하는 방법
				// list.add(new
				// MessageDTO(rs.getInt(1),rs.getString(2),null,rs.getString(3),rs.getString(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}

	// 메세지 삭제 기능
	public int messageDelete(String email, String num) {
		 // 메소드를 통해 넘길거기 때문에 문자나 숫자 상관없다!
		connect();
		
		
		
		try {
			sql = "delete from web_message where m_receiveEmail =? and m_num = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, num);  // 메소드를 통해 넘길거기 때문에 문자나 숫자 상관없다!
			
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		
		
		return cnt;

	}
	//메세지 전체 삭제
	public int messageAllDelete(String m_email) {
		
		connect();
		
		
		try {
			sql = "delete from web_message where m_receiveEmail = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, m_email);
			
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		
		
		
		
		
		return cnt;
	}

}
