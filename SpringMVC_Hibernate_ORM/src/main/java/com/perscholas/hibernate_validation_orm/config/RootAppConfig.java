package com.perscholas.hibernate_validation_orm.config;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.perscholas.hibernate_validation_orm.hibernate_session.HibernateUtil;

@Configuration
@ComponentScan("com.perscholas.hibernate_validation_orm")
@PropertySource("classpath:/application.properties")
public class RootAppConfig {
	@Autowired
	@Qualifier("mariaDbHibernateUtil")
//	@Qualifier("hsqlDbHibernateUtil")
	HibernateUtil hibernateUtil;
	
	@Bean("hibernateSession")
	public Session hibernateSession() {
		return hibernateUtil.getSessionFactory().openSession();
	}
}