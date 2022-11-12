package model;

import java.sql.SQLException;
import org.json.simple.JSONObject;

public class MemberService {
	
	MemberDAO memberDao;
	
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	@SuppressWarnings("unchecked")
	public String getMJDao(String userid, String userpw) throws ClassNotFoundException, SQLException {
			 Member member = memberDao.SelectM(userid, userpw);
		
			 JSONObject json = new JSONObject();
			 json.put("userpw", member.getUserpw());
			 json.put("name",member.getName());
			 json.put("num",member.getNum());
			 json.put("addr",member.getAddr());
			 json.put("tel",member.getTel());
			 JSONObject result = new JSONObject();
			 result.put("result", json);
		 	 
	  return result.toString();	
	}

	public JSONObject getIdDao (String id) throws ClassNotFoundException, SQLException {
		 MemberDAO dao= new MemberDAO();
		 int result = dao.SelectId(id);
		 
		 JSONObject json = new JSONObject();
		 json.put("result", result);
		 return json;
	}

	public JSONObject getPwDao(String pw) throws ClassNotFoundException, Exception {
		 MemberDAO dao= new MemberDAO();
		 int result = dao.SelectPw(pw);
		 
		 JSONObject json = new JSONObject();
		 json.put("result", result);
		 return json;
	}

}
