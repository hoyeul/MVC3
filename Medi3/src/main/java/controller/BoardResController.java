package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDao;
import model.BoardDto;
import model.BoardService;

@WebServlet("/board.con")
public class BoardResController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		String id  =(String) session.getAttribute("sessionID");
		if( id  != null){
			
			//전체 데이터 제공
			BoardService service = new BoardService();
			//전체조회리스트
			ArrayList<BoardDto> result = service.boradList();	//성공

			/*
			//확인
			for(BoardDto Dto :result) {
				System.out.println(Dto);
			}
			*/
			
			//꺼내는 방법이 다른건가...
			//response.getWriter().println(result);
			
			request.setAttribute("result", result);
			request.getRequestDispatcher("WEB-INF/views/BoardRes.jsp").forward(request, response);
		
		}
		else {
				
			PrintWriter out = response.getWriter();
			out.println("<script> alert('로그인 후 이용 가능한 페이지입니다.'); ");
			out.println( " window.location.href='/Medi3/login.do' </script>");
			
			 	//request.setAttribute("message", "게시판은 로그인후 이용가능합니다.");
			 	//request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);

			 	
			  
		}
		
		
		
	}
}
