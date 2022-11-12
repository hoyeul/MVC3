package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDao;


@WebServlet("/BoardEnter")
public class BoardEnter extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");	
		response.setContentType("text/plain;utf-8");
		
		HttpSession session = request.getSession();
		 
		String id  = (String)session.getAttribute("sessionID");	
		 if( id != null) {			 
			 System.out.println("회원");
			 request.getRequestDispatcher("WEB-INF/views/BoardEnter.jsp").forward(request, response);
		 }else {
			 //로그인화면요청
			 response.sendRedirect("longin.do");
			
		 }
				
		 //request.getRequestDispatcher("WEB-INF/views/BoardEnter.jsp").forward(request, response);
		

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//등록
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(content);
		
		 //==========================================================
		 // id를 구별하여 그에 맞는 페이지 제공하기 위한 name값 받아오기
	
		  HttpSession session = request.getSession();
		 
		  String id  = (String)session.getAttribute("sessionID");
		
		 if( id != null) {
			 
			 System.out.println("회원");
		 }
		 
		 
		
		  //String id = "Alphinaud";	//임시데이터
		  
		 //===========================================================
		 
		 BoardDao dao = new BoardDao();
		 
		 System.out.println(title);
		 System.out.println(content);
		 System.out.println(id);
		 
		 dao.enterBoard(title,content,id);	//잘됨
		 
		 
		 //페이지이동
		 response.sendRedirect("board.con");
		
	}
	

}
