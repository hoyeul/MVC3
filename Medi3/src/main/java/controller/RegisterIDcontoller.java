package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.MemberDAO;
import model.MemberService;


@WebServlet("/idcheck")
public class RegisterIDcontoller extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain; utf-8");
		String id = req.getParameter("userid");
		
		MemberDAO dao = new MemberDAO();
		MemberService service = new MemberService();

		service.setMemberDao(dao);
		
		JSONObject result = null;
		
		try {
			result = service.getIdDao(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().print(result);
	}
}
