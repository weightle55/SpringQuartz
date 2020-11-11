package com.example.batchandquartz.batchandquartz.qJob;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author jungheonlee@nhn.com
 */
@Component
public class AAAA implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("!@#!@#!@#!@#!@#");
	}
}

