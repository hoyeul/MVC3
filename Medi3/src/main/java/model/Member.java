package model;

public class Member {
	private String userid;
	private String userpw;
	private String name;
	private String num;
	private String addr;
	private String tel;
	//String health_checklist;
	
	public Member() {}
	
	public Member(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	

	public Member(String userid, String userpw, String name, String num, String addr, String tel) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.name = name;
		this.num = num;
		this.addr = addr;
		this.tel = tel;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
