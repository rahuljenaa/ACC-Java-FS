package com.accenture.ltt.job.configuration;

import java.util.Date;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobInstance;
public class MSDJobConfigListener implements JobExecutionListener {	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		JobInstance j=jobExecution.getJobInstance();
		System.out.println("[**MSDCustom message**]: Job started ["+new Date()+"]:"+j.getJobName()+", instance Id: "+j.getInstanceId());
	}
	@Override
	public void afterJob(JobExecution jobExecution) {
		JobInstance j=jobExecution.getJobInstance();
		if( jobExecution.getStatus() == BatchStatus.COMPLETED ){
	        //job success
			System.out.println("[**MSDCustom message**]: Job Completed Successfully: ["+new Date()+"]:"+j.getJobName()+", instance Id: "+j.getInstanceId());
	    }
	    else if(jobExecution.getStatus() == BatchStatus.FAILED){
	        //job failure
	    	System.out.println("Job Failed ["+new Date()+"]:"+j.getJobName()+", instance Id: "+j.getInstanceId());
	    }		
	}
}
