package com.message.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MemberDAO {
	
	//db����
	
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

	// ȸ�����Ա��
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

		} catch (SQLException e) { // ����ó���� �߻��ؼ� catch���� �ɸ��� close���� ���� �ʱ� ������ finally�� �־ ������ ���������� �����Ѵ�.
			//����ó�� �߻��Ǵ� ���!
			//1. SQL������ �߸� �ۼ��Ǿ��� ���
			//2. psmt��ü�� �߸��� �ε��� ���� �ۼ����� ���
			//3. ���̺��� ���� ���
			e.printStackTrace();
		}
		finally { //try -catch ���� ����� �� �ݵ�� �����ϱ� ���� finally
		close();
		}
		
		return cnt; //ȸ�������� �Ǹ� 0�� �ƴѰ��� ������ �ȴ�.
	}
	
	//�α��� ���
	
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
			
			if(rs.next()) { //ȸ�����Ե� ������ db�� �ִ°��
				member = new MemberDTO(email, null, rs.getString(1), rs.getString(2)); //1,2���� ���� �̸�(tel,address)
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
	//�����ڸ�忡�� ȸ�� ���� ����
	public ArrayList<MemberDTO> memberselectAll() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); 
		connect();
		
		
		try {
			sql = "select m_email, m_tel, m_address from web_member";
			psmt = conn.prepareStatement(sql);
			
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				//rs��ü �� ����� ȸ���������� ���� -> Member��ü ���� -> list�� ����
				String email = rs.getString(1);
				String tel = rs.getString(2);
				String address = rs.getString(3);
				
				if(!email.equals("admin")) { //������ ������ �����ϰ� ����
					MemberDTO member = new MemberDTO(email, null, tel, address);
					list.add(member);
				}
				
//				MemberDTO member = new MemberDTO(email, null, tel, address);
//				list.add(member);
				//�̷������ε� ����
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
