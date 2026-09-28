package com.accenture.ltt.controller;
 
import org.springframework.batch.core.Job;
import org.springframework.batch.repeat.policy.SimpleCompletionPolicy;
import org.springframework.batch.repeat.support.RepeatTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ltt.custom.launcher.CustomJobLauncher;
import com.accenture.ltt.custom.launcher.MyRepeatCallback;
 
@RestController
public class JobLauncherController {
 
    @Autowired
    CustomJobLauncher jobLauncher;
 
    @Autowired
    Job job;
 
    @Autowired
    RepeatTemplate repeatTemplate;
    
    
 /*   @RequestMapping("/launchjob")
    public String handle(@RequestParam("jobId")String jobId) throws Exception {
 
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
        	JobParameters jobParameters = new JobParametersBuilder().addString("jobId", jobId)
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
 
        return "Done!";
    }*/
    
    
    @RequestMapping("/launchjob")
    public String launchJobController(){
    	try{
    	System.out.println("Job will be executed by Scheduler"); 		
		  SimpleCompletionPolicy completionPolicy = new SimpleCompletionPolicy();
		  completionPolicy.setChunkSize(3);
		  repeatTemplate.setCompletionPolicy(completionPolicy);        
        repeatTemplate.iterate(new MyRepeatCallback(jobLauncher) );
    	}catch (Exception e) {
            e.printStackTrace();
        } 
        return "Done!";
    }
    
}