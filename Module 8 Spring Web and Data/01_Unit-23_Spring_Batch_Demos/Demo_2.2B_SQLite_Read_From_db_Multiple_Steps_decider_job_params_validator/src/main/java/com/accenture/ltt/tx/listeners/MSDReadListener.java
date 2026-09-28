package com.accenture.ltt.tx.listeners;

import java.util.Date;

import org.springframework.batch.core.ItemReadListener;

public class MSDReadListener implements ItemReadListener<Object> {

	@Override
	public void beforeRead() {
		System.out.println("Read Listener Started to execute on: "+new Date());
		
	}

	@Override
	public void afterRead(Object item) {
		System.out.println("Read Listener read["+item+"] on: "+new Date());
	}

	@Override
	public void onReadError(Exception ex) {
		System.out.println("Read Listener exception["+ex+"] on: "+new Date());
	}

}
