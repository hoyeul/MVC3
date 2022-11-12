package model;

import java.util.ArrayList;

public class BoardService {
	
	public ArrayList<BoardDto> boradList() {
		//전체조회리스트
		BoardDao dao = new BoardDao();
	
		ArrayList<BoardDto> result = dao.selectAll();
		return  result;
	
	}

}
