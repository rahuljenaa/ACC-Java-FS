package com.accenture.ltt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Import(Internationalization.class)//part of component scan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
/*
While executing pass the header 
Accept-Language = us
or next time
Accept-Language = fr
*/