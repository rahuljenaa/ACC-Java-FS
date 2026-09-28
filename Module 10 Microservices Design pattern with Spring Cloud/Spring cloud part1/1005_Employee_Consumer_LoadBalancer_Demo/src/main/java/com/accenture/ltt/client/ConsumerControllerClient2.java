package com.accenture.ltt.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerControllerClient2 {
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@RequestMapping(path="/consumer2/getDetails")
	public ResponseEntity<String> getEmployee(){
		//Load balancer round robin algorithm is applied and one instance of the producer is choosen
		ServiceInstance serviceInstance=loadBalancer.choose("cst-employee-producer");//Load balancer round robin algorithim is applied and one instance of the producer is choosen
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/emp/controller/getDetails";
	
		System.out.println(">>>From Client -> Server Instance Id port number: >>"+serviceInstance.getPort());
		
		//RestTemplate is not a Spring managed bean, it is user defined object
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=restTemplate.exchange(baseUrl,HttpMethod.GET,null,String.class);
		
		return response;
	}

	
}