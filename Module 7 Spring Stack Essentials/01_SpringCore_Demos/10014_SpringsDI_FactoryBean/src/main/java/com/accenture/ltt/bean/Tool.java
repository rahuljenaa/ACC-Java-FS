package com.accenture.ltt.bean;

public class Tool {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tool(int id) {
		super();
		this.id = id;
		System.out.println("Tool: ParamConst");
	}

	public Tool() {
		System.out.println("Tool: DefaultConst");
	}
}
 

