package model;

public class revDto {

	String rev_num;
	String rev_name;
	String rev_date;
	String rev_time;
	String rev_program;
	String rev_location;
	String rev_id;
	
	public revDto() {}

	public revDto(String rev_num, String rev_name, String rev_location, String rev_date, String rev_time, 
			String rev_program, String rev_id) {
		super();
		this.rev_num = rev_num;
		this.rev_name = rev_name;
		this.rev_location = rev_location;
		this.rev_date = rev_date;
		this.rev_time = rev_time;
		this.rev_program = rev_program;
		this.rev_id = rev_id;
	}

	public String getRev_num() {
		return rev_num;
	}

	public void setRev_num(String rev_num) {
		this.rev_num = rev_num;
	}

	public String getRev_name() {
		return rev_name;
	}

	public void setRev_name(String rev_name) {
		this.rev_name = rev_name;
	}

	public String getRev_location() {
		return rev_location;
	}

	public void setRev_location(String rev_location) {
		this.rev_location = rev_location;
	}
	
	public String getRev_date() {
		return rev_date;
	}

	public void setRev_date(String rev_date) {
		this.rev_date = rev_date;
	}

	public String getRev_time() {
		return rev_time;
	}

	public void setRev_time(String rev_time) {
		this.rev_time = rev_time;
	}

	public String getRev_program() {
		return rev_program;
	}

	public void setRev_program(String rev_program) {
		this.rev_program = rev_program;
	}

	public String getRev_id() {
		return rev_id;
	}

	public void setRev_id(String rev_id) {
		this.rev_id = rev_id;
	}

	@Override
	public String toString() {
		return "revDto [rev_num=" + rev_num + ", rev_name=" + rev_name + ", rev_location=" + rev_location + ", rev_date="
				+ rev_date + ", rev_time=" + rev_time + ", rev_program=" + rev_program + "]";
	}




	
}
