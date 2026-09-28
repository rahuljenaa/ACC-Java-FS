
package com.accenture.ltt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

//https://www.springboottutorial.com/spring-boot-content-negotiation-with-xml-json-representations
//https://www.baeldung.com/spring-boot-formatting-json-dates
//https://stackoverflow.com/questions/44459786/spring-rest-xml-datetime-format
//headers
//Accept application/json or application/xml