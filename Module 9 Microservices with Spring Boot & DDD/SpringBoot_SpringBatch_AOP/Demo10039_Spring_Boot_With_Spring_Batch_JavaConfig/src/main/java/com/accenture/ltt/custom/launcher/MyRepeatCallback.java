package com.accenture.ltt.custom.launcher;

import org.springframework.batch.repeat.RepeatCallback;
import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.RepeatStatus;

public class MyRepeatCallback implements RepeatCallback{

	private CustomJobLauncher customJobLauncher;

	 private Integer runCountActual=0;
	 private Integer runCountTarget=0;
	
	public MyRepeatCallback(CustomJobLauncher customJobLauncher){
		this.customJobLauncher = customJobLauncher;
		runCountTarget= customJobLauncher.getRunCount();
	}

	public RepeatStatus doInIteration(RepeatContext context) throws Exception {
		runCountActual++;
		if (runCountTarget<=runCountActual){
			return RepeatStatus.FINISHED;
		}
		customJobLauncher.run();
		return RepeatStatus.CONTINUABLE;
	}
}
