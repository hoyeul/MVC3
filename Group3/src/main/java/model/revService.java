package model;

import java.util.ArrayList;

public class revService {

	revDao dao;
	
	public revService() {}

	public revService(revDao dao) {
		super();
		this.dao = dao;
	}
	
	public revDto select(String key) {
		return dao.select(key);
	}
	
	public void insert(revDto dto) {
		dao.insert(dto);
	}
	
	public void delete(String key) {
		dao.delete(key);
	}

	
	public ArrayList<revDto> selectRev_time(revDto dto)  {
		return dao.selectRev_time(dto);
	}
	
}
