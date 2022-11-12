package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.MemberDAO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;utf-8");
		
		String userid = request.getParameter("userID");
		String userpw = request.getParameter("userPW");
		
		MemberDAO dao = new MemberDAO();
		int loginResult = dao.login(userid, userpw);
		
		
		if (loginResult == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", userid);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("loginResult", loginResult);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/loginFail.jsp");
			rd.forward(request, response);
		}
		
	}
	
}
