package com.myProject.Cricket.Config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@ComponentScan("com.myProject.Cricket.repository")
@EnableJpaRepositories(basePackages="com.myProject.Cricket.repository")
public class CricketPersistenceJpaConfig {
	
	/*
	@Primary
	@Bean(name="dataSource")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		
		return DataSourceBuilder.create().build();
	}*/

}
