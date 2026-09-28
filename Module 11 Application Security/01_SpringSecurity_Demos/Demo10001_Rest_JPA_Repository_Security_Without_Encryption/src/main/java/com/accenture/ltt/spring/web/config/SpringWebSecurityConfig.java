package com.accenture.ltt.spring.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.accenture.ltt.basic.entery.point.MyBasicAuthenticationEntryPoint;

// these annotations are used to declare this file as the Security File
@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfig {

	@Autowired
	private MyBasicAuthenticationEntryPoint entryPoint;
	
	
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
				.authenticationEntryPoint(entryPoint);
		return http.build();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin").password("{noop}admin123").roles("MSD_ADMIN")
            .and()
            .withUser("dba").password("{noop}dba123").roles("MSD_DBA")
            .and()
            .withUser("user").password("{noop}user123").roles("MSD_USER");
    }
}