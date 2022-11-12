package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.revDao;
import model.revDto;
import model.revService;

@WebServlet("/revUpdateController.do")
public class revUpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("asdfafasfasfadfda");
		HttpSession session = request.getSession();
		String id  =(String) session.getAttribute("sessionID");
		
		revDao dao = new revDao();
		revService s = new revService(dao);
		revDto dto = s.selectId(id);
		
		if( id  != null){
			
			if(dto.getRev_id() != null) {
				request.getRequestDispatcher("WEB-INF/views/revUpdateForm.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("WEB-INF/views/revUpdateBeforeForm.jsp").forward(request, response);
			}
			
		}
		else {
			request.getRequestDispatcher("WEB-INF/views/revAfterLogin.jsp").forward(request, response);
		}
	}
}
