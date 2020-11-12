package com.example.batchandquartz.batchandquartz.repository;

import com.example.batchandquartz.batchandquartz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author jungheonlee@nhn.com
 */
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAllByUserNameEquals(String userName);
	User findByUserName(String userName);
}
