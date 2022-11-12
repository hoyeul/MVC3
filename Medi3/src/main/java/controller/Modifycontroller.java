package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.MemberDAO;
import model.MemberService;

@WebServlet("/modify.do")
public class Modifycontroller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id  =(String) session.getAttribute("sessionID");
		if( id  != null){
			request.getRequestDispatcher("WEB-INF/views/m_modifychk.jsp").forward(request, response);
		}
		else {
			//response.sendRedirect("home.do");
			request.getRequestDispatcher("WEB-INF/views/m_modifyBeforeLogin.jsp").forward(request, response);
		}
		
}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain; utf-8");
		
		HttpSession session = req.getSession();
		String userid  =(String) session.getAttribute("sessionID");
		String userpw = req.getParameter("userpw");
		
		MemberDAO dao= new MemberDAO();
		
		Member member = null;
		try {
			member = dao.SelectM(userid, userpw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 req.setAttribute("member", member);
		 RequestDispatcher r = req.getRequestDispatcher("WEB-INF/views/m_modify.jsp");
		 r.forward(req, resp);
	}
}
	
