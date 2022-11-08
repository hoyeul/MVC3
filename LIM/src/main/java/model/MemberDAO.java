package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	
	/*
	 DAO(Data Access Object) 란 데이터베이스와 연동되며 값을 전달 하거나 전달 받는 역할
	*/
		
		public MemberDAO() {}
	
		private PreparedStatement pstmt;
		private ResultSet rs;
	
	//연결정보
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="1234";
		Connection con = null;
		

		private void dbCon() {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public int login(String userid, String userpw) {
			dbCon();
			String sql = "SELECT userpw FROM Member_info WHERE userid = ?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();
				
				System.out.print(rs);
				
				if(rs.next()) {
					if(rs.getString(1).equals(userpw)) 
						return 1;
					
					else
						return 0;
				}else {
					return -1;
			    }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -2;
		}
		
		 public String searchId(Member m)   {
			 
			dbCon();
			String sql = "SELECT userid FROM Member_info WHERE name = ? and tel = ? ";
			String s = "";
			
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, m.getName());
				pst.setString(2, m.getTel());
				ResultSet rs2 = pst.executeQuery();
				
				 if( rs2.next() ) {
					s =  rs2.getString(1);
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			return s;
		 }
		 
		 public String searchPw(String userid, String name) throws SQLException {
			 
				dbCon();
				String sql = "SELECT userpw FROM Member_info WHERE userid = ? and name = ? ";
				
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, userid);
					pstmt.setString(2, name);
					rs = pstmt.executeQuery();

	            if( rs.next() )
	            	return (rs.getString("userpw"));
	            else
	            	return null;
				} finally {
					
				if(rs!=null)
					try { 
						rs.close(); 
					} catch(SQLException ex) {}
				
				if (pstmt != null) 
					try { 
						pstmt.close(); } 
				catch(SQLException ex) {}

				}

			 }
		 
		 
		 /*
		 
		 아이디 체크 확인
		 public static void main(String[] args) throws SQLException {
				MemberDAO dao = new MemberDAO();
				String result = dao.searchId("김도련", "010-1234-5678");
				System.out.println(result);
			}
		*/
		 
		 /*
		 비밀번호 체크 완료
		 public static void main(String[] args) throws SQLException {
				MemberDAO dao = new MemberDAO();
				String result = dao.searchPw("Alphinaud", "김도");
				System.out.println(result);
			}
		*/
		 
		/*
		로그인시 아이디 중복체크 완료
		public static void main(String[] args) {
			MemberDAO dao = new MemberDAO();
			int result = dao.login("dfdf", "dfdfdf");
			System.out.println(result);
		}
		*/

}
