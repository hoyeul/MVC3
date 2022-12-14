package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDAO;

@WebServlet("/searchPW")
public class SearchPW_Servlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/searchPW.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;utf-8");
		
		String userid = request.getParameter("userID");
		String name = request.getParameter("userName");
		
		MemberDAO dao = new MemberDAO();
		String userpw = dao.searchPw(userid, name);
		
		request.setAttribute("pwResult", userpw);
		
		RequestDispatcher r = request.getRequestDispatcher("/WEB-INF/views/searchPW_success.jsp");
		r.forward(request, response);
	}
}
