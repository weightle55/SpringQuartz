package com.example.batchandquartz.batchandquartz.batchJob;

import com.example.batchandquartz.batchandquartz.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author jungheonlee@nhn.com
 */
//@Component
//public class UserUpdateJobConfig {
//
//	private static final int CHUNK_SIZE = 10;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	private final Logger logeger = LoggerFactory.getLogger(UserUpdateJobConfig.class);
//
//	@Bean(name="UserUpdate")
//	public Job userUpdateJob(Job)
//}
