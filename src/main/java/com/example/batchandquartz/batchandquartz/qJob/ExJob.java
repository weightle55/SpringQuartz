package com.example.batchandquartz.batchandquartz.qJob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jungheonlee@nhn.com
 */
public class ExJob extends QuartzJobBean {

	private static final Logger logger = LoggerFactory.getLogger(ExJob.class);
	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH시 mm분 ss초");
		String currentDate = sdf1.format(date);
		String currentTime = sdf2.format(date);
		/**
		 *  execute() method 로직 추가
		 */
		logger.info("====== ExJob execute() method Start !! ========");
		logger.info("Start Time >>> {}", currentDate + " " +currentTime);
	}
}
