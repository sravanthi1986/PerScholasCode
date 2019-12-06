package com.perscholas.restcontroller.config;

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
import com.perscholas.restcontroller.model.Student;




@Configuration
@EnableWebMvc
@ComponentScan("com.perscholas.restcontroller")
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
	Map<Integer, Student> studentMap() {
		Map<Integer, Student> sMap = new HashMap<>();
		Student student;
		// Create first student record
		String[] Clist= {"QE","Application developer","DE"};
		student = new Student(1, "Sravs","sravs@gmail.com",Clist);
		sMap.put(student.getStudentID(), student);
		// Create second student record
		student = new Student(2, "Charlie", "charlie@yahoo.com",Clist);
		sMap.put(student.getStudentID(), student);
		return sMap;
	}
}