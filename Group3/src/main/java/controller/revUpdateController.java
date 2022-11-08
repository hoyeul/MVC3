package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/revUpdateController.do")
public class revUpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id  =(String) session.getAttribute("id");
		if( id  != null){
			request.getRequestDispatcher("WEB-INF/views/revUpdateForm.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("login2.do2");
		}
	}
}
