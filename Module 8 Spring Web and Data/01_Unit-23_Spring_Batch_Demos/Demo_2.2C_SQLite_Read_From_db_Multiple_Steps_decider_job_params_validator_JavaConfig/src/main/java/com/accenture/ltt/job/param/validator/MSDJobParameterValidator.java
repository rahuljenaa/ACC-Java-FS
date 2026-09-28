package com.accenture.ltt.job.param.validator;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

public class MSDJobParameterValidator implements JobParametersValidator{

	@Override
	public void validate(JobParameters parameters)
			throws JobParametersInvalidException {
	
		System.out.println("From Job Parameters validate method");
    	String user= parameters.getString("user");
    	Long id =  parameters.getLong("id");
    	String str=null;
    	if(user==null || user.contains(" ")){
    		str="User name is null or Contains Spaces";
    	}
    	else if(id==null){
    		str="Id is missing";
    	}
    	if(str!=null){
    		throw new JobParametersInvalidException(str);
    	}
		
	}
	

}
