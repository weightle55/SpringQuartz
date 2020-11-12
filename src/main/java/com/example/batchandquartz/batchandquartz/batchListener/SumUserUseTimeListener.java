package com.example.batchandquartz.batchandquartz.batchListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * @author jungheonlee@nhn.com
 */
@Component
public class SumUserUseTimeListener implements JobExecutionListener {

	private final Logger logger = LoggerFactory.getLogger(SumUserUseTimeListener.class);

	@Override
	public void beforeJob(JobExecution jobExecution) {
		logger.info("Before SumUserUseTimeJob");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		logger.info("After SumUserUseTimeJob");
	}
}
