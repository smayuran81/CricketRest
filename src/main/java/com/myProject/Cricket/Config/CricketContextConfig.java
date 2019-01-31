package com.myProject.Cricket.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan({"com.myProject.Cricket.model"})
// @PropertySource({"classpath:application.properties"})
public class CricketContextConfig {
	
	
	public CricketContextConfig() {
		super();
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer proeprties() {
		
		final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
		return pspc;
	}
	

}
