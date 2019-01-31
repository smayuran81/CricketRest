package com.myProject.Cricket.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("com.myProject.Cricket.security")
/**
 * https://dzone.com/articles/how-does-http-basic-authentication-work-in-spring
 * @author sivam
 *
 */
public class CricketJavaSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Autowired
	public void configurerGlobalAuth(final AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsService);
		
	}
	
	@Override
	public void configure(final HttpSecurity http) throws Exception {
		//@// @formatter:off
		http.
		authorizeRequests().	
		//antMatchers(HttpMethod.GET).
		//permitAll().
		anyRequest().
		authenticated().
		and().
		httpBasic().and().
		sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
		csrf().disable(); 
		// @formatter:on

		
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);

	}

}
