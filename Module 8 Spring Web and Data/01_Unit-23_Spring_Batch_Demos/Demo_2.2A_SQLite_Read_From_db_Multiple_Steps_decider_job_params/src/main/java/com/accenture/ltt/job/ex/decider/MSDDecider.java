package com.accenture.ltt.job.ex.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class MSDDecider implements JobExecutionDecider {
	
	@Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
    	JobParameters jb = jobExecution.getJobParameters();
    	String user= jb.getString("username");
    	Long id =  jb.getLong("id");
    	
    	if (user.equals("ADMIN") && id.equals(11498686L)) {
        	System.out.println("***Decider*** "+FlowExecutionStatus.COMPLETED);
            return FlowExecutionStatus.COMPLETED;
        }
        else {
        	System.out.println("***Decider*** "+FlowExecutionStatus.FAILED);
            return FlowExecutionStatus.FAILED;
        }
    }

}
