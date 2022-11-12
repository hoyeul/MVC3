package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDao;

@WebServlet("/BordDelete")
public class BoardDelete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디 값을 받아와서 회원이고 작성자인경우 삭제 버튼 제공
		//삭제버튼에 게시물 번호 

		String c_num =request.getParameter("c_num");
		//String c_num ="7";
		System.out.println(c_num);
		BoardDao dao = new BoardDao();
		dao.deletBoard(c_num);
		
		response.sendRedirect("board.con");
		
		
	}
	
	

}
