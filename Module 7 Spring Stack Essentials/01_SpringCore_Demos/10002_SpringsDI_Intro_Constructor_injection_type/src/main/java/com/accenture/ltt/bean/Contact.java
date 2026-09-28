package com.accenture.ltt.bean;

public class Contact {
	private int id;
	private String email;
 
	public Contact(int id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", email=" + email + "]";
	}

 

}
