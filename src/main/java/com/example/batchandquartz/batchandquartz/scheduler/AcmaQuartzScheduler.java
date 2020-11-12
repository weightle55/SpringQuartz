package com.example.batchandquartz.batchandquartz.scheduler;

import com.example.batchandquartz.batchandquartz.qJob.sumUserUseTimeJob;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author jungheonlee@nhn.com
 */
@Component
public class AcmaQuartzScheduler {

	private static final Logger logger = LoggerFactory.getLogger(AcmaQuartzScheduler.class);

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private SchedulerFactoryBean fb;

	@PostConstruct
	public void start() throws Exception {
//		SchedulerFactoryBean fb = new SchedulerFactoryBean();
//		fb.afterPropertiesSet();
//		schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = fb.getScheduler();
//		scheduler.start();

		JobDetail batchjob = JobBuilder
				.newJob(sumUserUseTimeJob.class)
				.withIdentity("sumUserUseTimeJob")
				.build();
//
//		JobDetail job = JobBuilder
//				.newJob(AcmaQuartzJob.class)
//				.withIdentity("AcmaJob")
//				.build();
//
//		JobDetail job2 = JobBuilder.newJob(ExJob.class).withIdentity("ExJob").build();
//
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
						.build();

		scheduler.scheduleJob(batchjob,trigger);
	}

}
