package com.accenture.ltt.basic.entery.point;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	final public static String REALM="MSDNAMESPACE";
	@Override
	public void afterPropertiesSet()  {
		setRealmName(REALM);
		super.afterPropertiesSet();
	}

	
	// incase of authentication/ authorization fialure
	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException {
		response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + ""	);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authException.getMessage());
		
		
	}	
}