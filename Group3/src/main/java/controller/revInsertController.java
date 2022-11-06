package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.revDao;
import model.revDto;
import model.revService;

@WebServlet("/revInsertController.do")
public class revInsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/revInsertForm.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;utf-8");
		
		String rev_num = request.getParameter("rev_num");
		String rev_name = request.getParameter("rev_name");
		String rev_location = request.getParameter("rev_location");
		String rev_date = request.getParameter("rev_date");
		String rev_time = request.getParameter("rev_time");
		String rev_program = request.getParameter("rev_program");
		
		revDao dao = new revDao();
		revService s = new revService(dao);
		revDto dto = new revDto(rev_num, rev_name, rev_location, rev_date, rev_time, rev_program);
		s.insert(dto);
		
		response.sendRedirect("index.html");
		
		

	}
}
