package com.accenture.ltt.web.springconf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.accenture.ltt.dao","com.accenture.ltt.service"})
public class SpringRootContext {

}
