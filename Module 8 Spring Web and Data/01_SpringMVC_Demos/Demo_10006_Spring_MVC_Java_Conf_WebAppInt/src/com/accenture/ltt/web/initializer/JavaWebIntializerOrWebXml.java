package com.accenture.ltt.web.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.accenture.ltt.web.springconf.SpringRootContext;
import com.accenture.ltt.web.springconf.SpringWebContextConfigurator;

//WebApplicationInitializer
public class JavaWebIntializerOrWebXml implements WebApplicationInitializer {
	public void onStartup(ServletContext ctx) throws ServletException {

		//RootContext
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringRootContext.class);
		ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootContext);
		ctx.addListener(contextLoaderListener);

		//ChildContext
		AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
		webCtx.register(SpringWebContextConfigurator.class);
		webCtx.setServletContext(ctx);

		ServletRegistration.Dynamic servlet = ctx.addServlet("disp",
				new DispatcherServlet(webCtx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		servlet.addMapping("*.html");
	}

}

/*
 * Equivalent web.xml <?xml version="1.0" encoding="UTF-8"?> <web-app
 * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 * xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation=
 * "http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
 * version="3.0"> <welcome-file-list> <welcome-file>index.jsp</welcome-file>
 * </welcome-file-list> <servlet> <servlet-name>spring-web</servlet-name>
 * <servlet
 * -class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
 * <load-on-startup>1</load-on-startup> </servlet> <servlet-mapping>
 * <servlet-name>spring-web</servlet-name> <url-pattern>*.html</url-pattern>
 * </servlet-mapping>
 * 
 * 
 * <context-param> <param-name>contextConfigLocation</param-name>
 * <param-value>classpath:com/accenture/resources/myspringroot.xml</param-value>
 * </context-param> <listener>
 * <listener-class>org.springframework.web.context.ContextLoaderListener
 * </listener-class> </listener>
 */
