package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/*
 * RootContext used to configure Application common shared beans like databse connection, Property files etc 
 */

@Configuration
@ComponentScan(basePackages = "com.demo.site.controller", excludeFilters = @ComponentScan.Filter(Controller.class) )
public class RootContext {

}
