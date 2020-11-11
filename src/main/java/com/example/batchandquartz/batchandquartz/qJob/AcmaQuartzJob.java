package com.example.batchandquartz.batchandquartz.qJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jungheonlee@nhn.com
 */
public class AcmaQuartzJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(AcmaQuartzJob.class);

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH시 mm분 ss초");
		String currentDate = sdf1.format(date);
		String currentTime = sdf2.format(date);
		/**
		 *  execute() method 로직 추가
		 */
		logger.info("====== acmQuartzJob execute() method Start !! ========");
		logger.info("Start Time >>> {}", currentDate + " " +currentTime);
	}
}
