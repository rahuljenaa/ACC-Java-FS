package com.accenture.lkm.web.test;



//static imports to use the mockito API
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.accenture.lkm.web.custom.test.utils.JSONUtils;
import com.accenture.ltt.Application;
import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.service.EmployeeService;
import com.accenture.ltt.web.controller.EmployeeController;

//Following Annotation is used to tell that Spring is used to run the tests 
@ExtendWith(SpringExtension.class)

//Following Annotation is replacement of @Configuration annotation
//it is used to point to the files having the configuration and helps to load and start the context
//Context will be cached for all test cases and classes
@SpringBootTest(classes=Application.class)
// No @Transactional Required as database is never hit
public class GetAndGetAllTests {
	//Step1: Step1: Declare Service Layer Mocks and inject to Controller
	@Mock
	private EmployeeService serviceIMPL;
	// this @mock annotation, instructs the mockito
	// to analyze the class or interface and produce 
	// a test stub (empty methods) with same public methods and signatures
	
	//Step1: Declare Service Layer Mocks and inject to Controller
	@InjectMocks
	private EmployeeController controller;
	// this annotation, tells mockito to inject mocked objects
	// into the EmployeeController
	// in our case the serviceIMPL will be supplied to EmployeeController
    protected MockMvc mockMVC;
    
    @BeforeEach
    public void mySetup(){ 	
	    //It is done to initialize mockito annotations for mocking
	    //prepare the objects for testing
    	MockitoAnnotations.openMocks(this);
    	//Step2:  Using Use MockMvcBuilders to create a MockMvc which is replica just of Controller
    	mockMVC = MockMvcBuilders.standaloneSetup(controller).build();
	}
    
    @SuppressWarnings("unchecked")
	@Test
    public void getAllEmployeesTest() throws Exception{
    	  String uri="/emp/controller/getDetails";
    	  
    	  //Step3: Use MockHttpServletRequestBuilder to create a request
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get(uri);
    	  
    	  //Step4: Define the Mocking call for the mocked object created in Step1 and provided to controller 
    	  when(serviceIMPL.getEmployeeDetails()).thenReturn(getEmployeeStubData());
    	  
    	  //Step5: MockMvc created in Step2 will perform() the request created in Step3 and will yield MvcResult
    	  ResultActions rest= mockMVC.perform(request);
    	  MvcResult mvcREsult= rest.andReturn();
		  
    	  //Step6: Extract the actual response content and response status from MvcResult obtained above 
    	  //and compare with the expected response content and expected response status
		  String result= mvcREsult.getResponse().getContentAsString();
		  int actualStatus= mvcREsult.getResponse().getStatus();
    	 
    	  List<EmployeeBean> listEmp= JSONUtils.covertFromJsonToObject(result, List.class);
    	  
    	  //Step7: Verify if the Controller is able to delegate the call to the mock
    	  //One of the TEST CASE 
		  verify(serviceIMPL,times(1)).getEmployeeDetails();
    	  
    	  Assertions.assertNotNull(listEmp);
    	  Assertions.assertEquals(actualStatus,HttpStatus.OK.value());
    }
    
    
    @Test
    public void getEmployeeByIdTest() throws Exception{
    	  String uri="/emp/controller/getDetailsById/1003";
    	  
    	  //Step3: Use MockHttpServletRequestBuilder to create a request
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get(uri);
    	  
    	  //Step4: Define the Mocking call for the mocked object created in Step1 and provided to controller 
    	  when(serviceIMPL.getEmployeeDetailByEmployeeId(1003)).thenReturn(Optional.ofNullable(new EmployeeBean("Rocky",1003, 90011.1,102)));
    	  
          //Step5: MockMvc created in Step2 will perform() the request created in Step3 and will yield MvcResult
    	  ResultActions rest= mockMVC.perform(request);
    	  
    	  //Step6: Extract the actual response content and response status from MvcResult obtained above and compare with the expected response content and expected response status
    	  MvcResult mvcREsult= rest.andReturn();
		  String result= mvcREsult.getResponse().getContentAsString();
		  //actual status and name
		  int statusAct= mvcREsult.getResponse().getStatus();
		  EmployeeBean emp= JSONUtils.covertFromJsonToObject(result, EmployeeBean.class);
		  	  
		   //Step7: Verify if the Controller is able to delegate the call to the mock
		  //As we expect the controller to invoke the getEmployeeDetails() method of serviceIMPL wrapper once 
		  //So to check the same whether controller is actually able to invoke the same or not
		  //We have written the following statement.		   
		  verify(serviceIMPL,times(1)).getEmployeeDetailByEmployeeId(1003);
  	  
		  Assertions.assertNotNull(emp);
    	  Assertions.assertTrue(emp.getEmployeeName().equals("Rocky"));
    	  Assertions.assertEquals(statusAct,HttpStatus.OK.value());
    }
    @Test
    public void getEmployeeByIdInvalidTest() throws Exception{
    	  String uri="/emp/controller/getDetailsById/10006";
    	  
    	  //Step3: Use MockHttpServletRequestBuilder to create a request
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get(uri);
    	  
    	  //Step4: Define the Mocking call for the mocked object created in Step1 and provided to controller 
    	  when(serviceIMPL.getEmployeeDetailByEmployeeId(10006)).thenReturn(Optional.empty());
    	  
          //Step5: MockMvc created in Step2 will perform() the request created in Step3 and will yield MvcResult
    	  ResultActions rest= mockMVC.perform(request);
    	  
    	  //Step6: Extract the actual response content and response status from MvcResult obtained above and compare with the expected response content and expected response status
    	  MvcResult mvcREsult= rest.andReturn();
		  int statusAct= mvcREsult.getResponse().getStatus();
		  	  
		   //Step7: Verify if the Controller is able to delegate the call to the mock
		  //As we expect the controller to invoke the getEmployeeDetails() method of serviceIMPL wrapper once 
		  //So to check the same whether controller is actually able to invoke the same or not
		  //We have written the following statement.		   
		  verify(serviceIMPL,times(1)).getEmployeeDetailByEmployeeId(10006);
  	  
		  Assertions.assertEquals(statusAct,HttpStatus.NOT_FOUND.value());
    }
   
	public List<EmployeeBean> getEmployeeStubData(){
		return Arrays.asList(new EmployeeBean("Jack", 1001,90011.1,101),new EmployeeBean("Amy",1002, 90011.1,102),
							 new EmployeeBean("Justin",1004, 90011.1,101),new EmployeeBean("Cynthya",1005, 90011.1,102));
	}
    
}