package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";

	Connection con = null;
	
	private void dbcon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			if (con != null ) {
				System.out.println("OKIDOKIYO");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//게시물 하나에 대한 전체 자료!
	public BoardDto selectone(String c_num){
		BoardDto oneDto = new BoardDto();
		
		dbcon();
		
		String sql = " select * from content where  c_num =? ";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c_num);
			
			ResultSet rs = pst.executeQuery();
			
			if ( rs.next() ) {

				c_num = rs.getString(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String c_date = rs.getString(4);
				String c_name = rs.getString(5);
				
				oneDto.setC_num(c_num);
				oneDto.setTitle(title);
				oneDto.setContent(content);
				oneDto.setC_date(c_date);
				oneDto.setC_name(c_name);
				
				
			}
			
			pst.close();
			con.close();
			rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return oneDto;
		
	}
	
	
	//게시판 리스트 
	//밖에서 값을 받와야서 이곳에서 해당 데이터를 
	public ArrayList<BoardDto> selectAll() {
		ArrayList<BoardDto> selectAll = new  ArrayList<>();

		dbcon();
		
		//클릭된 제목 => re.getString(nummer)
		String sql =" select lpad(c_num,2,0), title, to_char(c_date,'yyyy-mm-dd'), c_name from content ";
			   sql += "order by c_num desc";
		//
		try {
			PreparedStatement pst  = con.prepareStatement(sql);
			ResultSet  rs = pst.executeQuery();
		
			
			while( rs.next()) {
				BoardDto boardDto = new BoardDto();
				String c_num = rs.getString(1);
				String title = rs.getString(2);
				String c_date = rs.getString(3);
				String c_name = rs.getString(4);
				
	
	
				boardDto.setC_num(c_num);
				boardDto.setTitle(title);
				boardDto.setC_date(c_date);
				boardDto.setC_name(c_name);
				
				selectAll.add(boardDto);
			
			}
			pst.close();
			con.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return selectAll;
	}
	
	//등록
	public void enterBoard(String title,String content ,String c_name) {
	 
		
		System.out.println("title= " + title);
		System.out.println("content = "  + content );
		System.out.println("id=" + c_name);
		
		dbcon();
		
		String sql = " insert into content values(board_seq.nextval,?,?,CURRENT_TIMESTAMP,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			//pst.setString(1, c_num);	//자동으로 할수 있지않은가.
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setString(3, c_name);
			
			pst.executeUpdate();
			

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//수정
	
	public void upDataBoard(String c_num,String title,String content) {
		
		dbcon();
		
		String sql = " update content set title= ?,content=? ,c_date=CURRENT_TIMESTAMP  where c_num = ? ";
		
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setString(3, c_num);
			
			pst.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	//삭제
	public void deletBoard(String c_num) {
		String num = c_num;
		System.out.println("dao=" + num);
		dbcon();
		
		String sql = "delete from content where c_num =? ";
		
		
		try {
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, num);
			pst.executeUpdate();
			
			System.out.println("OK");
			
			pst.close();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		
	}
	
	
	
	public static void main (String[] args) {
		BoardDao dao = new BoardDao();
		//dao.dbcon();	//연결 성공함~!
		
		/*
		ArrayList<BoardDto> bbb = dao.selectAll();	//성공
		
		for(BoardDto Dto :bbb) {
			System.out.println(Dto);
		}
		*/
		/*
		BoardDto aaa = dao.selectone("3");	//성공
		System.out.println(aaa);
		*/
		
		//dao.deletBoard("15");	//매우잘됨
		
		
		//dao.enterBoard("ddd","ddd","444444444");
		//String title,String content ,String c_name
		
		
		        //String title= "아나바나";
			    //String  content = "와라라라";
				//String  id="Alisaie";	//없는 사람이라 안됨
		
		 //dao.enterBoard(title,content,id);
		
		//수정
		//dao.upDataBoard();	//잘됨
		
		ArrayList<BoardDto> bbb = dao.selectAll();
		for(BoardDto Dto :bbb) {
			System.out.println(Dto);
		}
	}
	
}
