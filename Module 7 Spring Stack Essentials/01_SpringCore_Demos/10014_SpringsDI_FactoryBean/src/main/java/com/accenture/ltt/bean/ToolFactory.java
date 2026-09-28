package com.accenture.ltt.bean;

import org.springframework.beans.factory.FactoryBean;

public class ToolFactory implements FactoryBean<Tool> {
	private int factoryId;
    private int toolId;
	@Override
	public Tool getObject() throws Exception {
		System.out.println("ToolFactory: From: Get Object");
		 return new Tool(toolId);
	}

	@Override
	public Class<?> getObjectType() {
 		System.out.println("ToolFactory: From: Get Object Type");
		return Tool.class;
	}

	@Override
	public boolean isSingleton() {
		System.out.println("ToolFactory: From: Is Single Ton");
		  return false; // change to true and observe
	}

	public int getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(int factoryId) {
		System.out.println("ToolFactory: From Setter: FatoryId:"+factoryId);
		this.factoryId = factoryId;
	}

	public int getToolId() {
		return toolId;
	}

	public void setToolId(int toolId) {
		System.out.println("ToolFactory: From Setter: toolId:"+toolId);
		this.toolId = toolId;
	}
	
}