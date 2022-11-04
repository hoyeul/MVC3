package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class revDao {

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
	
	public void insert(revDto dto) {
		
		dbCon();
		String sql = " insert into rev values(?,?,?,?,?,?) ";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, dto.getRev_num());
			pst.setString(2, dto.getRev_name());
			pst.setString(3, dto.getRev_date());
			pst.setString(4, dto.getRev_time());
			pst.setString(5, dto.getRev_location());
			pst.setString(6, dto.getRev_program());
			pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
