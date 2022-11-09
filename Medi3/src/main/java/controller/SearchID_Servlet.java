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

@WebServlet("/searchID")
public class SearchID_Servlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/searchID.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;utf-8");
		
		String name = request.getParameter("userName");
		String tel = request.getParameter("userTel");
		
		MemberDAO dao = new MemberDAO();
		Member m = new Member(name, tel);
		String userid = dao.searchId(m);
		
		request.setAttribute("idResult", userid);
		
		RequestDispatcher r = request.getRequestDispatcher("/WEB-INF/views/searchID_success.jsp");
		r.forward(request, response);
		
	}
}


// userName userTel