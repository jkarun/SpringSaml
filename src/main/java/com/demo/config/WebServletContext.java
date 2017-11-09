package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
 * WebServletContext used to configure Application view side configurations like View resolver, Request/Response content managements, etc 
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.demo.site.controller", includeFilters = @ComponentScan.Filter(Controller.class) )
public class WebServletContext {

	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/jsp/");
		view.setSuffix(".jsp");
		view.setViewClass(JstlView.class);
		return view;
	}
	
}
