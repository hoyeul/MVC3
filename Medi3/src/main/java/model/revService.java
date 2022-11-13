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
	
	public void update(revDto dto) {
		dao.update(dto);
	}
	
	public void delete(String key) {
		dao.delete(key);
	}

	public ArrayList<revDto> selectRev_time(revDto dto)  {
		return dao.selectRev_time(dto);
	}
	
	public revDto selectId(String key) {
		return dao.selectId(key);
	}
	
	public int selectNum(String key) {
		return dao.selectNum(key);
	}
	
	public String selectName(String key) {
		return dao.selectName(key);
	}
	
	public ArrayList<String> selectNums(String key){
		return dao.selectNums(key);
	}
	
}
