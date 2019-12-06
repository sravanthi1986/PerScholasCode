package com.perscholas.software_developer_club.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@ComponentScan("com.perscholas.software_developer_club.controllers")
public class WebAppConfig implements WebMvcConfigurer {
    @Bean
    InternalResourceViewResolver resolver() {
    	return  new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        //return resolver;
    }
}