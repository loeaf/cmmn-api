package com.spo.cmmn.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableRedisHttpSession
public class SpoCmmnAdminApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(SpoCmmnAdminApplication.class, args);
	}

}
