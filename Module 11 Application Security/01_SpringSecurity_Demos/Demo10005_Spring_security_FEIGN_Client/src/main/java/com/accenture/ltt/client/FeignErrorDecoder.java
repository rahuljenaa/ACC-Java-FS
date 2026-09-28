package com.accenture.ltt.client;

import org.springframework.stereotype.Component;

import feign.Response;
import feign.codec.ErrorDecoder;
@Component
public class FeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		if (response.status() == 500 || response.status() == 404) {
			return new RuntimeException("Employee with given id doesnt exists");
		}
		if (response.status() == 403) {
			return new RuntimeException("You are authenticated but not authorized to access this functionality");
		}
		if (response.status() == 401) {
			return new RuntimeException("You are not authenticated to access this functionality");
		}
		return null;
	}
}