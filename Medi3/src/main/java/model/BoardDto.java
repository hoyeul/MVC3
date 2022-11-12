package model;

import java.text.SimpleDateFormat;

public class BoardDto {
	String c_num;
	String title;
	String content;
	String c_date;
	String c_name;
	
	public BoardDto() {}
	
	public BoardDto(String c_num, String title, String content, String c_date, String c_name) {
		this.c_num = c_num;
		this.title = title;
		this.content = content;
		this.c_date = c_date;
		this.c_name = c_name;
	}
	public BoardDto(String c_num, String title, String c_date, String c_name) {
		this.c_num = c_num;
		this.title = title;
		this.c_date = c_date;
		this.c_name = c_name;
	}


	public String getC_num() {
		return c_num;
	}

	public void setC_num(String c_num) {
		this.c_num = c_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	@Override
	public String toString() {
		return "BoardDto [c_num=" + c_num + ", title=" + title + ", content=" + content + ", c_date=" + c_date
				+ ", c_name=" + c_name + "]";
	}
	


}
