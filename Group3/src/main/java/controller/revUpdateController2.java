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

@WebServlet("/revUpdateController2.do")
public class revUpdateController2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;utf-8");
		
		String rev_num = request.getParameter("rev_num");
		
		revDao dao = new revDao();
		revService s = new revService(dao);
		revDto dto = s.select(rev_num);
		
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("WEB-INF/views/revUpdateForm2.jsp").forward(request, response);
	}
	
}
