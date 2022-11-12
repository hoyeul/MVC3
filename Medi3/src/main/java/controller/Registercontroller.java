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

import model.Member;
import model.MemberDAO;

@WebServlet("/register.do")
public class Registercontroller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String id  =(String) session.getAttribute("sessionID");
			if( id  == null){
				request.getRequestDispatcher("WEB-INF/views/m_register.jsp").forward(request, response);
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
		
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		String name = req.getParameter("name");
		String num = req.getParameter("num");
		String addr = req.getParameter("addr");
		String tel = req.getParameter("tel");
		
		Member member = new Member(userid,userpw,name,num,addr,tel);
		
		MemberDAO DAO= new MemberDAO();
		
		try {
			DAO.InsertM(member);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 req.setAttribute("name", name);
		 RequestDispatcher r = req.getRequestDispatcher("WEB-INF/views/m_registersuccess.jsp");
		 r.forward(req, resp);
	}
}
