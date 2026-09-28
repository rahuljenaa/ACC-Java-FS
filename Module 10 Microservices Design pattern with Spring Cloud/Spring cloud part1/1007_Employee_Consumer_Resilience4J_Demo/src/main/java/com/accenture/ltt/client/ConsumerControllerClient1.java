package com.accenture.ltt.client;

import java.io.IOException;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerControllerClient1 {

	@RequestMapping(value = "/to-read1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getEmployee() throws RestClientException, IOException {

		String baseUrl = "http://localhost:7091/emp/controller/getDetails";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return response.getBody();
	}
}