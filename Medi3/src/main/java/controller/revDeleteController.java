package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.revDao;
import model.revService;

@WebServlet("/revDeleteController.do")
public class revDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;utf-8");
		
		String rev_num = request.getParameter("rev_num");
		revDao dao = new revDao();
		revService s = new revService(dao);
		s.delete(rev_num);
		
		request.getRequestDispatcher("WEB-INF/views/revDeleteForm.jsp").forward(request, response);
	}

}