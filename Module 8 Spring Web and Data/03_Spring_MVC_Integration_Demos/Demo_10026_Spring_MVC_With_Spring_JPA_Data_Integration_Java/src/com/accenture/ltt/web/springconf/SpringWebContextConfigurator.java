package com.accenture.ltt.web.springconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
// Equivalent to <mvc:annotation-driven />
@ComponentScan(basePackages = "com.accenture.ltt.web.controller")
public class SpringWebContextConfigurator {
	@Bean
	public ViewResolver configureViewResolvers() {
		// TODO Auto-generated method stub
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jspViews/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
//Equivalent XML is 
/*
 * 
 * <beans xmlns="http://www.springframework.org/schema/beans"
 * xmlns:context="http://www.springframework.org/schema/context"
 * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 * xmlns:mvc="http://www.springframework.org/schema/mvc" xsi:schemaLocation="
 * http://www.springframework.org/schema/beans
 * http://www.springframework.org/schema/beans/spring-beans.xsd
 * http://www.springframework.org/schema/context
 * http://www.springframework.org/schema/context/spring-context.xsd
 * http://www.springframework.org/schema/mvc
 * http://www.springframework.org/schema/mvc/spring-mvc.xsd">
 * 
 * <!-- scanning just web related dependencies --> <context:component-scan
 * base-package="com.accenture.lkm.web" />
 * 
 * <!--adds support for MVC annotations: 1. @Valid annotation for validation
 * 2. @RequestMapping 3. http message convertors or message body marshalling
 * with @RequestBody/ResponseBody --> <mvc:annotation-driven />
 * 
 * 
 * <!-- View Resolver to resolve the views from a custom location --> <bean
 * class="org.springframework.web.servlet.view.InternalResourceViewResolver">
 * <property name="prefix"> <value>/WEB-INF/jspViews/</value> </property>
 * <property name="suffix"> <value>.jsp</value> </property> </bean>
 * 
 * </beans>
 * 
 */
