package com.spo.cmmn.admin.config;

import java.util.List;

import com.spo.cmmn.admin.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/*
 * 2022.11.17. 박현우
 * 
 * Redis 세션 설정
 * 
 * 세션을 Redis로 관리하기 위해 설정
 * 
 */
@Configuration
@EnableRedisHttpSession
public class RedisHttpSessionConfig {
	
	@Value("${spring.redis.host}")
	private String redisHost;
	
	@Value("${spring.redis.port}")
	private int redisPort;

	@Value("${spring.redis.password}")
	private String password;
	
	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		var clusterConfig = new LettuceConnectionFactory(redisHost, redisPort);
		clusterConfig.setPassword(password);
		return clusterConfig;
//		RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(redisNodes);
//		redisClusterConfiguration.setPassword("qweasd12");
//		return new LettuceConnectionFactory(redisClusterConfiguration);
	}
	
	
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
//		redisTemplate.setKeySerializer(new StringRedisSerializer());
//		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(SessionDTO.class));
		return redisTemplate;
	}
	
}
