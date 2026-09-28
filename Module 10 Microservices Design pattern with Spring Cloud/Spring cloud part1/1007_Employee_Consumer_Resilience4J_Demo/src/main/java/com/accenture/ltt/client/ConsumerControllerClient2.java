package com.accenture.ltt.client;

import java.io.IOException;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ConsumerControllerClient2 {

	private static final String RESILIENCE4J_INSTANCE_NAME = "jasKeyCompute";
	
	private ResponseEntity<String> response = null;
	
	@RequestMapping(value = "/to-read2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = "subscribesFallbackMethod")
	public ResponseEntity<String> getEmployee() throws RestClientException, IOException {
		System.out.println("Consumer calling Producer app");
		String baseUrl = "http://localhost:7091/emp/controller/getDetails";
		RestTemplate restTemplate = new RestTemplate();
		response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);
		return new ResponseEntity<String>(response.getBody(), HttpStatus.OK);
	}
	
	public ResponseEntity<String> subscribesFallbackMethod(InternalServerError e) {
		System.out.println("\tProducer app responded with InternalServerError, generating cached response ");
		return new ResponseEntity<String>(response.getBody(), HttpStatus.OK);
	}
	
	public ResponseEntity<String> subscribesFallbackMethod(CallNotPermittedException e) {
		System.out.println("Circuit is in open state, Consumer not calling Producer app, generating cached response ");
		return new ResponseEntity<String>(response.getBody(), HttpStatus.OK);
	}
}