package com.example.batchandquartz.batchandquartz.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author jungheonlee@nhn.com
 */
@Entity
@DynamicUpdate
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;

	@Column
	private String userName;

	@Column
	private Long useTime;

	@Column(name = "registerDateTime")
	private LocalDateTime registerDateTime;

	public Long getIdx() {
		return idx;
	}

	public void setIdx(Long idx) {
		this.idx = idx;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUseTime() {
		return useTime;
	}

	public void setUseTime(Long useTime) {
		this.useTime = useTime;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}

	public static User userBuilder(String userName){
		User user = new User();
		user.setUserName(userName);
		return user;
	}

	public void useTime(Long useTime){
		this.setUseTime(useTime);
	}

	public void registerDateTime(LocalDateTime registerDateTime){
		this.setRegisterDateTime(registerDateTime);
	}

	public User build(){
		return this;
	}
}
