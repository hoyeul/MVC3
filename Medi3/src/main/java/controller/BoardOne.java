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

@WebServlet("/BordOne")
public class BoardOne extends HttpServlet {
		

	
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String c_num =request.getParameter("c_num");
		 //String c_num = "3"; //임의의 숫자
	

		 //===========================================================
		 BoardDao dao = new BoardDao();
		 BoardDto result = dao.selectone(c_num);	
		 
		 System.out.println(result); //출력잘됨
		 
		 request.setAttribute("result", result);
		 request.getRequestDispatcher("WEB-INF/views/BoardOne.jsp").forward(request, response);
		 
		 
	}

}
