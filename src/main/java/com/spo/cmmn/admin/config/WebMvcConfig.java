package com.spo.cmmn.admin.config;


import com.spo.cmmn.admin.interceptor.CmnInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {	
	@Autowired
    CmnInterceptor cmmnInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		
        registry.addInterceptor(cmmnInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/admin/sys/common/trnsc/authrt")
                .excludePathPatterns("/error");
        
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	}
}
