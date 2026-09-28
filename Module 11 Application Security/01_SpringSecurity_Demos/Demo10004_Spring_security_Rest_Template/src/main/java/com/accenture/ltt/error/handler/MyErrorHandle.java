package com.accenture.ltt.error.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class MyErrorHandle implements ResponseErrorHandler{
	
	private boolean flag=false;

	@Override
	public void handleError(ClientHttpResponse arg0) throws IOException {
		if (flag)
			System.out.println("Your are not authenicated/authorized to access the functionality");
		else
			System.out.println("Employee with the given id doesn't exists");
	}

	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
		if(httpResponse.getStatusCode()==HttpStatus.FORBIDDEN || httpResponse.getStatusCode()==HttpStatus.UNAUTHORIZED) {
			flag=true;
		return true;
		}else if(httpResponse.getStatusCode()==HttpStatus.NOT_FOUND||httpResponse.getStatusCode()==HttpStatus.INTERNAL_SERVER_ERROR) {
			flag=false;
		return true;
		}
		return false;
	}
	
}