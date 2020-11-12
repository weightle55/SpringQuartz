package com.example.batchandquartz.batchandquartz.batchJob;

import com.example.batchandquartz.batchandquartz.entity.User;
import com.example.batchandquartz.batchandquartz.entity.UserSum;
import com.example.batchandquartz.batchandquartz.repository.UserRepository;
import com.example.batchandquartz.batchandquartz.repository.UserSumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * @author jungheonlee@nhn.com
 */
@Configuration
public class SumUserUseTimeJobConfig {

	private static final int CHUNK_SIZE = 10;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserSumRepository userSumRepository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private JobRepository jobRepository;

	private final Logger logger = LoggerFactory.getLogger(SumUserUseTimeJobConfig.class);

	@Bean(name = "sumUserUseTimeJob")
	public Job sumUserUseTimeJob(JobBuilderFactory jobBuilderFactory, Step sumUserUseTimeStep){
		return jobBuilderFactory.get("sumUserUseTimeJob")
//				.preventRestart()
				.start(sumUserUseTimeStep)
				//.incrementer(new RunIdIncrementer())
				.build();
	}

	@Bean
	@JobScope
	public Step sumUserUseTimeStep(StepBuilderFactory stepBuilderFactory){
		return stepBuilderFactory.get("sumUserUseTimeStep")
				.<User,UserSum> chunk(CHUNK_SIZE)
				.reader(sumUserUseTimeReader())
				.processor(sumUserUseTimeProcessor())
				.writer(sumUserUseTimeWriter())
				.taskExecutor(taskExecutor())
				.build();
	}

	@Bean
//	@StepScope
	public ListItemReader<User> sumUserUseTimeReader(){
		logger.info(Thread.currentThread().getName());
		List<User> sumUserUseTime = userRepository.findAll();
		//User tmp = userRepository.findByUserName("test");
		logger.info("======= Item Reader ========");
		return new ListItemReader<>(sumUserUseTime);
	}

	public ItemProcessor< User, UserSum> sumUserUseTimeProcessor() {
		logger.info("======= Item Processor ========");
		return new ItemProcessor<User, UserSum>() {
			@Override
			public UserSum process(User user) throws Exception {
				System.out.println("!@#!@#!@#!@#! " + user);
				long sumOfAll = user.getUseTime();
				UserSum userSum = userSumRepository.findByUserName(user.getUserName());
				userSum.setUserName("test");
				userSum.setSumOfUseTime(userSum.getSumOfUseTime()+sumOfAll);
				return userSum;
			}
		};
	}

	public JpaItemWriter<UserSum> sumUserUseTimeWriter() {
		logger.info("======= Item Writer ========");
		JpaItemWriter<UserSum> jpaItemWriter = new JpaItemWriter<>();
		jpaItemWriter.setEntityManagerFactory(entityManagerFactory);
		return jpaItemWriter;
	}

	@Bean
	public TaskExecutor taskExecutor(){
		return new SimpleAsyncTaskExecutor("Batch_Task");
	}

}
