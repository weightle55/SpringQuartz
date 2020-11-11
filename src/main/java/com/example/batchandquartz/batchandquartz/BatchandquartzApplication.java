package com.example.batchandquartz.batchandquartz;

import com.example.batchandquartz.batchandquartz.qJob.AAAA;
import com.example.batchandquartz.batchandquartz.scheduler.AcmaQuartzScheduler;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchandquartzApplication {

	@SuppressWarnings("unused")
	@Autowired
	private AcmaQuartzScheduler scheduler;

	@Autowired
	private AAAA aaaa;

	public static void main(String[] args) {
		SpringApplication.run(BatchandquartzApplication.class, args);
	}

}
