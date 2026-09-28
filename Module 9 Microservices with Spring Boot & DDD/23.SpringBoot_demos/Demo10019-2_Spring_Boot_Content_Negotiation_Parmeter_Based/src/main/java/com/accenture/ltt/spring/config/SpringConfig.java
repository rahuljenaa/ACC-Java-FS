
package com.accenture.ltt.spring.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer{
	@SuppressWarnings("deprecation")
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	    configurer.favorPathExtension(false).
	    favorParameter(true).
	    parameterName("resType").
	    ignoreAcceptHeader(true).
	    defaultContentType(MediaType.APPLICATION_JSON).
	    mediaType("res1", MediaType.APPLICATION_XML). 
	    mediaType("res2", MediaType.APPLICATION_JSON); 
	}
}
/*
https://www.baeldung.com/spring-mvc-content-negotiation-json-xml
https://spring.io/blog/2013/05/11/content-negotiation-using-spring-mvc
https://www.baeldung.com/web-mvc-configurer-adapter-deprecated
*/