package com.accenture.ltt.tx.listeners;

import java.util.Date;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class MSDStepListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.out.println("Step ["+stepExecution.getStepName()+"] Started to execute on: "+new Date()+", Commit Count: "+stepExecution.getCommitCount());
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("Step ["+stepExecution.getStepName()+"] Finished to execute on: "+new Date()+", Commit Count: "+stepExecution.getCommitCount()+", Step Status:"+stepExecution.getStatus());
		return stepExecution.getExitStatus();
	}

	/*@Override
	public void afterStep() throws Exception {
		
	}

	@Override
	public void beforeStep() throws Exception {
		System.out.println("Step Finished to execute on: "+new Date());	
	}*/
	

}
