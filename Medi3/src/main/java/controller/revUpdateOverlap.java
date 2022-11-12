package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.revDao;
import model.revService;

@WebServlet("/revUpdateOverlap.do")
public class revUpdateOverlap extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sessionID");
		int rev_num = Integer.parseInt(request.getParameter("rev_num"));
		int j = 0;
		
		revDao dao = new revDao();
		revService s = new revService(dao);
		ArrayList<Integer> list = s.selectNums(id);
		
		for(int i = 0; i < list.size(); i++){
			if(rev_num == list.get(i)) {
				j++;
			}
		}
		
		if(j == 1) {
			request.setAttribute("rev_num", request.getParameter("rev_num"));
			request.getRequestDispatcher("WEB-INF/views/revUpdateFormOverlap.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/views/revWrongNum.jsp").forward(request, response);
		}

	}
}
