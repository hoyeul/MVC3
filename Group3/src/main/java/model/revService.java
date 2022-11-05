package model;

public class revService {

	revDao dao;
	
	public revService() {}

	public revService(revDao dao) {
		super();
		this.dao = dao;
	}
	
	public void insert(revDto dto) {
		dao.insert(dto);
	}
	
	public void delete(revDto dto) {
		dao.delete(dto);
	}
	
}
