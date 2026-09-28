package com.accenture.ltt.tester;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UITester {
	
	    public static void main(String[] args) {
	        
	    	ApplicationContext applicationContext = new 
	    			ClassPathXmlApplicationContext("classpath:spring-batch-config.xml");
	    		         
	        JobLauncher jobLauncher = (JobLauncher) applicationContext.getBean("jobLauncher");
	        Job job = (Job) applicationContext.getBean("firstBatchJob");	       
	        try {
	        	JobParametersBuilder jbBuilder =  new JobParametersBuilder();	        	
	        	JobParameters jbp= jbBuilder.addString("username", "ADMIN").addLong("id", 11498686L).toJobParameters();	        	
	            JobExecution execution = jobLauncher.run(job,jbp);
	            System.out.println("Job Status : " + execution.getStatus());
	            System.out.println("Job completed");
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Job failed");
	        }
	    }

}
