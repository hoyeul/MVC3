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
			String id = "";
			
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, m.getName());
				pst.setString(2, m.getTel());
				ResultSet rs2 = pst.executeQuery();
				
				 if( rs2.next() ) {
					 id =  rs2.getString(1);
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			return id;
		 }
		 
		 public String searchPw(String userid, String name) {
			 
				dbCon();
				String sql = "SELECT userpw FROM Member_info WHERE userid = ? and name = ? ";
				String userpw = null;
				
				try {
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, userid);
					pstmt.setString(2, name);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						userpw = rs.getString("userpw");
					}
				}catch(Exception e) {
						System.out.println(e);
					}
					return userpw;
				
		 }
					
		public void InsertM(Member member) throws ClassNotFoundException, SQLException {
		dbCon();
		String sql =" insert into Member_info values (?,?,?,?,?,?) ";
		PreparedStatement  pst = con.prepareStatement(sql);
		pst.setString(1, member.getUserid());
		pst.setString(2, member.getUserpw());
		pst.setString(3, member.getName());
		pst.setString(4, member.getNum());
		pst.setString(5, member.getAddr());
		pst.setString(6, member.getTel());
		
		pst.executeUpdate();
		
		pst.close();
		con.close();
	}
	
	public Member SelectM(String userid, String userpw) throws ClassNotFoundException, SQLException {
		dbCon();
		String name = "";
		String num = "";
		String addr ="";
		String tel ="";
		
		String sql = "select * from Member_info where userid = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, userid);
		ResultSet rs  = pst.executeQuery();
		while (rs.next()) {
			userid = rs.getString(1);
			userpw = rs.getString(2);
			name = rs.getString(3);
			num =  rs.getString(4);
			addr = rs.getString(5);
			tel =  rs.getString(6);
		}
		
		Member member = new Member(userid, userpw, name, num, addr, tel);
		rs.close();
		pst.close();
		con.close();
		return member;
	}
	
	public int SelectId (String id) throws ClassNotFoundException, SQLException {
		dbCon();
		String sql = "select userid from Member_info where userid = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs  = pst.executeQuery();
		if (rs.next()) return 0;
		else return 1;
		}
	
	public int SelectPw(String pw) throws ClassNotFoundException, Exception {
		dbCon();
		String sql = "select userpw from Member_info where userpw = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, pw);
		ResultSet rs  = pst.executeQuery();
		if (rs.next()) return 1;
		else return 0;
	}
	
	public void UpdateM(Member member) throws ClassNotFoundException, SQLException {
		dbCon();
		String sql ="update Member_info set userid = ? , userpw= ? , name= ? , num= ? , "
				+ " addr= ?, tel= ? where userid = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, member.getUserid());
		pst.setString(2, member.getUserpw());
		pst.setString(3, member.getName());
		pst.setString(4, member.getNum());
		pst.setString(5, member.getAddr());
		pst.setString(6, member.getTel());
		pst.setString(7, member.getUserid());
		
		pst.executeUpdate();
		
		pst.close();
		con.close();
	}
	
	public void DeleteM(String userid, String userpw) throws ClassNotFoundException, SQLException {
		dbCon();
		String sql = "delete from Member_info where userid = ? and userpw = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,userid);
		pst.setString(2,userpw);
		pst.executeUpdate();
		
		pst.close();
		con.close();
	}


	public static void main(String[] args) throws ClassNotFoundException, Exception {
		MemberDAO dao = new MemberDAO();
		int result = dao.SelectPw("asdf");
		System.out.println(result);
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
				String result = dao.searchPw("Alphinaud", "김도련");
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

