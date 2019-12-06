package org.raisingkids.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("org.raisingkids")
public class WebAppConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// Register resource handler for CSS and JS
		//registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/", "D:/statics/")
		//		.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

		// Register resource handler for images
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
