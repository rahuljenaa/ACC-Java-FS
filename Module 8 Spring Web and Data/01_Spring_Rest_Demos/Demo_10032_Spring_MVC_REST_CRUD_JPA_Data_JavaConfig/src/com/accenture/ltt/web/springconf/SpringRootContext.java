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
