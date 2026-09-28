package com.accenture.lkm.spring.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.accenture.lkm.basic.entery.point.MyBasicAuthenticationEntryPoint;

// these annotations are used to declare this file as the Security File
@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfig {

	@Autowired
	private MyBasicAuthenticationEntryPoint basicAuthenticationEntryPoint;
	
	public SpringWebSecurityConfig() {
		System.out.println("I am from SpringWebSecurityConfig()");
	}
	/*
	 * AUTHORIZATION CONFIGURATION
	 */
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable(); 
		
		http.authorizeRequests()			
		        .antMatchers("/emp/controller/addEmp**").access("hasRole('MSD_ADMIN')")
		        .antMatchers("/emp/controller/updateEmp**").access("hasRole('MSD_ADMIN')")
		        .antMatchers("/emp/controller/deleteEmp/**").access("hasRole('MSD_ADMIN')")
				.antMatchers("/emp/controller/getDetails**").access("hasAnyRole('MSD_ADMIN','MSD_DBA','MSD_USER')")
				.antMatchers("/emp/controller/getDetailsById/**").access("hasRole('MSD_ADMIN') or hasRole('MSD_DBA')")
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().httpBasic().realmName(MyBasicAuthenticationEntryPoint.REALM)
				.authenticationEntryPoint(basicAuthenticationEntryPoint);
		return http.build();
	}
	
	/*
	 * AUTHENTICATION CONFIGURATION
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception {	
		auth
		//.ldapAuthentication()
		//.jdbcAuthentication()
		.inMemoryAuthentication()
		.passwordEncoder(new BCryptPasswordEncoder())
		.withUser("msd_user").password(new BCryptPasswordEncoder().encode("msd_user")).roles("MSD_USER").and()
		.withUser("msd_admin").password(new BCryptPasswordEncoder().encode("msd_admin")).roles("MSD_ADMIN").and()
		.withUser("msd_dba").password(new BCryptPasswordEncoder().encode("msd_dba")).roles("MSD_DBA");
	}
}