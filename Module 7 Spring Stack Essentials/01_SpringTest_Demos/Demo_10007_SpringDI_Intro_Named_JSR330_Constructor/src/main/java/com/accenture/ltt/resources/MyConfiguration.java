package com.accenture.ltt.resources;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.accenture.ltt")
public class MyConfiguration {
	
	
}
// if Bean name is not given then the bean is created by the name of the method