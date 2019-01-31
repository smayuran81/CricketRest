package com.myProject.Cricket.Config;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@ComponentScan({ "come.myproject.Cricket" })
@EnableWebMvc
public class CricketWebConfig implements WebMvcConfigurer {

	public CricketWebConfig() {
		super();

	}

	@Override
	public void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {

		Optional<HttpMessageConverter<?>> converterFound = converters.stream()
				.filter(c -> c instanceof AbstractJackson2HttpMessageConverter).findFirst();

		if (converterFound.isPresent()) {

			final AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter) converterFound
					.get();
			converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
			converter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		}

		Optional<HttpMessageConverter<?>> converterXMLFound = converters.stream()
				.filter(c -> c instanceof MappingJackson2XmlHttpMessageConverter).findFirst();

		if (converterXMLFound.isPresent()) {

			final AbstractJackson2HttpMessageConverter converterXML = (MappingJackson2XmlHttpMessageConverter) converterFound
					.get();
			converterXML.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
			converterXML.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		}

	}

	@Bean
	public javax.validation.Validator localValidatorFactoryBean() {
		return new LocalValidatorFactoryBean();
	}

}
