package com.example.batchandquartz.batchandquartz.entity;

import javax.persistence.*;

/**
 * @author jungheonlee@nhn.com
 */
@Entity
@Table
public class UserSum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;

	@Column
	private String userName;

	@Column
	private Long sumOfUseTime;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getSumOfUseTime() {
		return sumOfUseTime;
	}

	public void setSumOfUseTime(Long sumOfUseTime) {
		this.sumOfUseTime = sumOfUseTime;
	}

	public UserSum(String userName, Long sumOfUseTime) {
		this.userName = userName;
		this.sumOfUseTime = sumOfUseTime;
	}
}
