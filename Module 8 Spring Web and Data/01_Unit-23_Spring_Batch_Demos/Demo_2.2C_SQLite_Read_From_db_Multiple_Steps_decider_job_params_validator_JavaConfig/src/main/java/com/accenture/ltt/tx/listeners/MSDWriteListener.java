package com.accenture.ltt.tx.listeners;

import java.util.Date;
import java.util.List;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

@Component
public class MSDWriteListener implements ItemWriteListener<Object> {

	@Override
	public void beforeWrite(List<? extends Object> items) {
		System.out.println("Write Listener before writing: "+items+", on: "+new Date());
	}

	@Override
	public void afterWrite(List<? extends Object> items) {
		System.out.println("Write Listener after writing: "+items+", on: "+new Date());
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Object> items) {
		System.out.println("Write Listener not able to write: "+items+", on: "+new Date()+", exception: "+exception);
	}

}
