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

	// db����

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
			// ����ó���� ������ �ߴ°��!
			// 1. OracleDriver Ŭ������ �ش���ü ���� ���(ojdbc6.jar �� ������ ���°��)
			// �ذ��� : WEB-INF ���� - lib���� �ȿ� ojdbc6.jar ����!
			// 2. OracleDriver ��ΰ� ��Ÿ�� ���
			e.printStackTrace();
		} catch (SQLException e) {
			// ����ó���� ������ �ߴ°��!
			// DB���� ������ ��Ȯ���� ���� ���
			e.printStackTrace();
		}

	}

	// DB��������
	// �������� �ݾ��ش�!
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

	// ���� �޼��� db�� ����
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
	// �޼��� �ҷ�����
	public ArrayList<MessageDTO> messageSelect(String email) {

		ArrayList<MessageDTO> list = new ArrayList<MessageDTO>();

		connect();

		try {
			sql = "select m_num,m_sendName,m_content,m_sendDate from web_message where m_receiveEmail = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);

			rs = psmt.executeQuery();

			while (rs.next()) {

				// ������ ��Ƽ� �߰��ϴ� ���
				int m_num = rs.getInt(1);
				String m_sendName = rs.getString(2);
				String m_content = rs.getString(3);
				String m_sendDate = rs.getString(4);

				MessageDTO message = new MessageDTO(m_num, m_sendName, null, m_content, m_sendDate);
				list.add(message);

				// �ٷ� �߰��ϴ� ���
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

	// �޼��� ���� ���
	public int messageDelete(String email, String num) {
		 // �޼ҵ带 ���� �ѱ�ű� ������ ���ڳ� ���� �������!
		connect();
		
		
		
		try {
			sql = "delete from web_message where m_receiveEmail =? and m_num = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, num);  // �޼ҵ带 ���� �ѱ�ű� ������ ���ڳ� ���� �������!
			
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		
		
		return cnt;

	}
	//�޼��� ��ü ����
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
