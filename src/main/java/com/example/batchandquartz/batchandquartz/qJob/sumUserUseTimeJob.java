package com.example.batchandquartz.batchandquartz.qJob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author jungheonlee@nhn.com
 */
// @Component
public class sumUserUseTimeJob extends QuartzJobBean {

	private static final Logger logger = LoggerFactory.getLogger(sumUserUseTimeJob.class);

//	private String jobName;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job sumUserUseTimeJob;

//	@Autowired
//	private JobLocator jobLocator;

//	public String getJobName() {
//		return jobName;
//	}
//
//	public void setJobName(String jobName) {
//		this.jobName = jobName;
//	}
//
//	public JobLauncher getJobLauncher() {
//		return jobLauncher;
//	}
//
//	public void setJobLauncher(JobLauncher jobLauncher) {
//		this.jobLauncher = jobLauncher;
//	}
//
//	public JobLocator getJobLocator() {
//		return jobLocator;
//	}
//
//	public void setJobLocator(JobLocator jobLocator) {
//		this.jobLocator = jobLocator;
//	}

	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		JobParameters jobParameters = new JobParametersBuilder().toJobParameters();

		try {
			JobExecution jobExecution = jobLauncher.run(sumUserUseTimeJob,jobParameters);

			logger.info("######### Status : {}",jobExecution.getStatus());
		} catch(JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e){
			e.printStackTrace();
		}
	}
}
