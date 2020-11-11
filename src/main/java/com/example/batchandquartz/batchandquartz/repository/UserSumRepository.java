package com.example.batchandquartz.batchandquartz.repository;

import com.example.batchandquartz.batchandquartz.entity.UserSum;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jungheonlee@nhn.com
 */
public interface UserSumRepository extends JpaRepository<UserSum, Long> {
	UserSum findByUserName(String userName);
}
