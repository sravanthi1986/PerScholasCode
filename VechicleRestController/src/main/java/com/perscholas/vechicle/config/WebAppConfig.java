package com.perscholas.vechicle.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.perscholas.vechicle.model.Vechicle;


@Configuration
@EnableWebMvc
@ComponentScan("com.perscholas.vechicle")
public class WebAppConfig implements WebMvcConfigurer {
	@Bean
	InternalResourceViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
	@Bean
	ObjectMapper objectMapper() {
		// INDENT_OUTPUT allows for "pretty printing" of JSON data
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	}
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	// This bean creates a map which will emulate database records.
	@Bean
	Map<Integer, Vechicle> vechicleMap() {
		Map<Integer, Vechicle> sMap = new HashMap<>();
		Vechicle vechicle;
		// Create first student record
		String[] test= {"red","green"};
		vechicle = new Vechicle(1, "make1","model1",test);
		sMap.put(vechicle.getVechicleID(), vechicle);
		// Create second student record
		vechicle = new Vechicle(2, "make2", "model2",test);
		sMap.put(vechicle.getVechicleID(), vechicle);
		return sMap;
	}
}