package com.myProject.Cricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.myProject.Cricket.Config.CricketContextConfig;
import com.myProject.Cricket.Config.CricketPersistenceJpaConfig;
import com.myProject.Cricket.Config.CricketServiceConfig;
import com.myProject.Cricket.Config.CricketWebConfig;

@SpringBootApplication
@Import( {
	CricketMainConfig.class
})
/**
 * 
 * @author sivam
 * SpringBootServletInitializer will let the application to deployed as normal 
 * war application
 */
public class CricketMainApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CricketMainApplication.class, args);
	}
	
	/**
	 * 
	 * @return
	 * Only required it to run as a war file. This replaces  the 
	 * traditional web.xml file
	 * 
	 * The below beans are only required if it is going to deployed as war file
	 */
/*	@Bean
	public DispatcherServlet dispatcherServlet() {
		
		return new DispatcherServlet();
	}
	
	@Bean
	public ServletRegistrationBean dispatcherSevletRegistration() {
		
		final ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(),"/api");
		
		final Map<String,String> params = new HashMap<String,String>();
		
		params.put("ContextClass", "org.springframework.context.annotation.AnnotationConfigApplicationContext");
		params.put("contextConfigLocation", "org.spring.sec2.spring");
		params.put("dispatchOptionsRequest", "true");
		registration.setInitParameters(params);
		
		registration.setLoadOnStartup(1);
		return registration;
	}
	
	@Override
	public  SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		
		return application.sources(RestCouurseApplication.class);
		
	}*/

}

