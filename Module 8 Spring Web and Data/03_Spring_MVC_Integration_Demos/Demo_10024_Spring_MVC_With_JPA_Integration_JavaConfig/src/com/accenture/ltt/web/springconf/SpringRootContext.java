package com.accenture.ltt.web.springconf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.accenture.ltt.db.config.SpringDBConfig;

@Configuration
@ComponentScan({"com.accenture.ltt.dao","com.accenture.ltt.service"})
@Import(SpringDBConfig.class)
public class SpringRootContext {

}
/* Equivalent XML 
 * <beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="
        http://www.springframework.org/schema/beans     
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context.xsd">

	<context:component-scan base-package="com.accenture.ltt.dao,com.accenture.ltt.service" />
</beans>
 * */
 