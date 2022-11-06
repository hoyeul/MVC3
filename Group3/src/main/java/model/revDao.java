package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			pst.setString(3, dto.getRev_location());
			pst.setString(4, dto.getRev_date());
			pst.setString(5, dto.getRev_time());
			pst.setString(6, dto.getRev_program());
			pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public revDto select(String key) {
		
		dbCon();
		String sql = " select * from rev where rev_num = ? ";
		revDto dto = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, key);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				dto = new revDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	
	public void delete(revDto dto) {
		
		dbCon();
		String sql = " delete from rev where rev_num = ? ";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, dto.getRev_num());
			pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<revDto> selectRev_time(revDto dto){
		dbCon();
		ArrayList<revDto> list = new ArrayList<>();
		
		String sql = " select rev_time from rev where rev_location = ? and rev_date = ? ";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, dto.getRev_location());
			pst.setString(2, dto.getRev_date());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				dto = new revDto();
				dto.setRev_time(rs.getString(1));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
