package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;

@WebServlet("/delete.do")
public class Deletecontroller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String id  =(String) session.getAttribute("sessionID");
			if( id  != null){
				request.getRequestDispatcher("WEB-INF/views/m_delete.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("login.do");
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
		
		MemberDAO DAO= new MemberDAO();
		
		try {
			DAO.DeleteM(userid, userpw);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		 req.setAttribute("result", 1);
		 session.invalidate();
		 RequestDispatcher r = req.getRequestDispatcher("WEB-INF/views/m_deletesuccess.jsp");
		 r.forward(req, resp);
	}
}
