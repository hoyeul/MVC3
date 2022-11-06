package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.revDao;
import model.revDto;
import model.revService;

@WebServlet("/revInsertTimeController.do")
public class revInsertTimeController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;utf-8");
		
		String revLocation = request.getParameter("revLocation");
		String revDate = request.getParameter("revDate");
		//System.out.println(revLocation + revDate);
		
		JSONArray JSONArray = new JSONArray();
		
		revDao dao = new revDao();
		revService s = new revService(dao);
		revDto dto = new revDto();
		dto.setRev_location(revLocation);
		dto.setRev_date(revDate);
		ArrayList<revDto> list;
		
		list = s.selectRev_time(dto);
		for(revDto dto2 : list) {
			JSONObject JSONObject = new JSONObject();
			JSONObject.put("revTime", dto2.getRev_time());
			JSONArray.add(JSONObject);
		}
		
		response.getWriter().print(JSONArray);

	}
}
