package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDAO;

@WebServlet("/modify2.do")
public class Modifycontroller2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
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
			DAO.UpdateM(member);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 req.setAttribute("name", name);
		 
		 RequestDispatcher r = req.getRequestDispatcher("WEB-INF/views/m_modifysuccess.jsp");
		 r.forward(req, resp);
	}
}
