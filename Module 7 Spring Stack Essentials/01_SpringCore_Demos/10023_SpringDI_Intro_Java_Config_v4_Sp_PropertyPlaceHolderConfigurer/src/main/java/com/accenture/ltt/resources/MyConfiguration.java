package com.accenture.ltt.resources;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ReaderConfig.class)
@ComponentScan(basePackages="com.accenture.ltt")
public class MyConfiguration {
	
}
