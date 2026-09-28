package com.accenture.lkm.web.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.accenture.lkm.web.custom.test.utils.JSONUtils;
import com.accenture.ltt.Application;
import com.accenture.ltt.business.bean.EmployeeBean;

//Following Annotation is used to tell that Spring is used to run the tests 
@ExtendWith(SpringExtension.class)

//Following Annotation is replacement of @Configuration annotation
//it is used to point to the files having the configuration and helps to load and start the context
//Context will be cached for all test cases and classes
@SpringBootTest(classes=Application.class)

//Following Annotation is used to run each test case in a individual Transaction
//with default strategy as rollback, as service layer is hitting DB layer
//so changes done to database must be undone
@Transactional
//https://docs.spring.io/spring/docs/4.2.4.RELEASE/spring-framework-reference/html/integration-testing.html
//To make the Test Cases WebApplicationContext aware 
@WebAppConfiguration
public class CreateEmployeeTest {

    @Autowired
    WebApplicationContext webApplicationContext; // cached
    
    protected MockMvc mockMVC;
     
    @BeforeEach
    public void mySetup(){
		//making the mockMVC aware of the all the application components
		mockMVC= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
    @Test
    public void createEmployeeTest() throws Exception{ 
    	  String uri="/emp/controller/addEmp";
    	  EmployeeBean employee = new EmployeeBean("Jack@123",0,90011.1,102);
    	  String employeeJsonFormat =JSONUtils.covertFromObjectToJson(employee);
    	  
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.post(uri)
    			  //ResponseContentType: what test case/ test client expects in return
    			  .accept(MediaType.TEXT_HTML) 
    			  //Data what is sent to server as RequestBody
    			  .content(employeeJsonFormat) 
    			  //Data type of the data being sent to server
    			  .contentType(MediaType.APPLICATION_JSON) ;
    	  
    	  ResultActions rest= mockMVC.perform(request);
    	  MvcResult mvcResult= rest.andReturn();
		   
		  String finalResult= mvcResult.getResponse().getContentAsString();
		  int actualStatus = mvcResult.getResponse().getStatus();
		  
		  Assertions.assertNotNull(finalResult);
		  Assertions.assertTrue(finalResult.contains("Employee added successfully with id"));
		  Assertions.assertEquals(actualStatus,HttpStatus.CREATED.value());
		  
    }
}