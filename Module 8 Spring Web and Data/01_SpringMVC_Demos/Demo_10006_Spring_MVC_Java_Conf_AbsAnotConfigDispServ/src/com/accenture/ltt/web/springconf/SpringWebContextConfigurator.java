package com.accenture.ltt.web.springconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // Equivalent to <mvc:annotation-driven />
@ComponentScan(basePackages = "com.accenture.ltt.web")
//public class SpringWebContextConfigurator {
//	@Bean
//	public ViewResolver configureViewResolvers() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/jspViews/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//	}
//	
//}

public class SpringWebContextConfigurator implements WebMvcConfigurer {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jspViews/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}
}


/*
 * Equivalent XML <beans xmlns="http://www.springframework.org/schema/beans"
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
 * <context:component-scan base-package="com.accenture.ltt.web" />
 * 
 * <bean
 * class="org.springframework.web.servlet.view.InternalResourceViewResolver">
 * <property name="prefix"> <value>/WEB-INF/jsp/</value> </property> <property
 * name="suffix"> <value>.jsp</value> </property> </bean>
 * 
 * <mvc:annotation-driven />
 * 
 * </beans>
 */
