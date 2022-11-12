package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDao;
import model.BoardDto;

@WebServlet("/BoardUpdate")
public class BoardUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		 
		String id = request.getParameter("c_num");
		BoardDao dao = new BoardDao();
		BoardDto result = dao.selectone(id);
		

		request.setAttribute("result", result);	
		request.getRequestDispatcher("WEB-INF/views/BoardUpdate.jsp").forward(request, response);

		//String id = request.getParameter("c_name");
		
		
		
		 
		

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//수정 할 데이터 

		String c_num =request.getParameter("c_num");
		System.out.println(c_num);
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		//===========================================================
		 
		 BoardDao dao = new BoardDao();
		 dao.upDataBoard(c_num,title,content);
		 
		 response.sendRedirect("board.con");
			
		 
		
	}
	

}
