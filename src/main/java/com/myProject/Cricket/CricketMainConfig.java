package com.myProject.Cricket;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.myProject.Cricket.Config.CricketContextConfig;
import com.myProject.Cricket.Config.CricketPersistenceJpaConfig;
import com.myProject.Cricket.Config.CricketServiceConfig;
import com.myProject.Cricket.Config.CricketWebConfig;

@Import( {
	CricketContextConfig.class,
	CricketPersistenceJpaConfig.class,
	CricketServiceConfig.class,
	CricketWebConfig.class
})
@Configuration
public class CricketMainConfig {

}
