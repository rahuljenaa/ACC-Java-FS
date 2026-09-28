package com.accenture.ltt.tx.listeners;

import java.util.Date;

import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

@Component
public class MSDProcessListener implements ItemProcessListener<Object, Object>{

	@Override
	public void beforeProcess(Object item) {
		System.out.println("Before Process Listener: "+item+", on "+new Date());
	}

	@Override
	public void afterProcess(Object item, Object result) {
		System.out.println("After Process Listener, input: "+item+" output: "+result+", on "+new Date());
	}

	@Override
	public void onProcessError(Object item, Exception e) {
		System.out.println("Process Listener not able to complete, input: "+item+" output Exception: "+e+", on "+new Date());
	}

}
