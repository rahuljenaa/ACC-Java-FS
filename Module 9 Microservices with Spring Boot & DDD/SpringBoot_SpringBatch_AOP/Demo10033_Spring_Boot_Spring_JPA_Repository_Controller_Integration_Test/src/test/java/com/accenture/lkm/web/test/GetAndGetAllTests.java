package com.accenture.lkm.web.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
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

//To make the Test Cases WebApplicationContext aware 
@WebAppConfiguration
public class GetAndGetAllTests {

    @Autowired
    private WebApplicationContext webApplicationContext; // cached
    
    protected MockMvc mockMVC;
      
    @BeforeEach
    public void mySetup(){
		//making the mockMVC aware of the all the application components
		mockMVC= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
    @SuppressWarnings("unchecked") 
    @Test
    public void getAllEmployeesTest() throws Exception{
    	  String uri="/emp/controller/getDetails";
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get(uri);
    	  ResultActions rest= mockMVC.perform(request); //Request is sent 
    	  MvcResult mvcResult= rest.andReturn();
		  
    	  //actual status and result
		  String result= mvcResult.getResponse().getContentAsString();
		  int actualStatus= mvcResult.getResponse().getStatus();
    	  
    	  //As RestControllerProduces Json result, converting from Json to Java Objects
    	  List<EmployeeBean> listEmp= JSONUtils.covertFromJsonToObject(result, List.class);
    	    
    	  //Testing: Comparing Expected with Actual
    	  Assertions.assertNotNull(listEmp);
    	  Assertions.assertEquals(actualStatus,HttpStatus.OK.value());	  
    }
    
    
    @Test
    public void getEmployeeByIdTest() throws Exception{
    	  String uri="/emp/controller/getDetailsById/1003";
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get(uri);
    	  ResultActions rest= mockMVC.perform(request);
    	  MvcResult mvcResult= rest.andReturn();
		   
		  String result= mvcResult.getResponse().getContentAsString();
		  //actual status and name
		  int statusAct= mvcResult.getResponse().getStatus();	
		  //As RestControllerProduces Json result, converting from Json to Java Objects
		  EmployeeBean emp= JSONUtils.covertFromJsonToObject(result, EmployeeBean.class);
		    
		  //Testing: Comparing Expected with Actual
		  Assertions.assertNotNull(emp);
		  Assertions.assertTrue(emp.getEmployeeName().equals("Rocky"));
		  Assertions.assertEquals(statusAct,HttpStatus.OK.value());
    }
    
    @Test
    public void getEmployeeByIdInvalidTest() throws Exception{
    	  String uri="/emp/controller/getDetailsById/10006";
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get(uri);
    	  ResultActions rest= mockMVC.perform(request);
    	  MvcResult mvcResult= rest.andReturn();
		  //actual status and name
		  int statusAct= mvcResult.getResponse().getStatus();	
		    
		  Assertions.assertEquals(statusAct,HttpStatus.NOT_FOUND.value());
    }
    
}