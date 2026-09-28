package com.accenture.ltt.custom.launcher;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

public class CustomJobLauncher {

	JobLauncher jobLauncher;

	Job job;
	
	private Integer runCount;

	public CustomJobLauncher(JobLauncher jobLauncher, Job job,Integer runCount) {
		super();
		System.out.println("From Launcher");
		this.jobLauncher = jobLauncher;
		this.job = job;
		this.runCount=runCount;
	}

	public void run() {
		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong(
					"time", System.currentTimeMillis()).toJobParameters();
			JobExecution execution = jobLauncher.run(job, jobParameters);
			System.out.println("Exit Status : " + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer getRunCount() {
		return runCount;
	}
	
	
}
// P.S JobParamater need to be unique each time a batch job to run, for testing
// purpose, we just pass in a new Date() everything running the job.
// https://www.mkyong.com/spring-batch/spring-batch-and-spring-taskscheduler-example/