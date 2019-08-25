package models;

import java.util.Date;

public class Email {
	static int count = 0; 
	int id;
	String email;
	Date date;


	public Email(String email) {
		super();
		this.email = email;
		this.id = count++;
		
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
