package  com.accenture.ltt.test;

import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.exceptions.EmployeeNotFoundException;
import com.accenture.ltt.service.EmployeeServiceImpl;


@ExtendWith(SpringExtension.class)

// Following is  @ContextConfiguration annotation
// it is used to point to the files having the configuration and helps to load and start the context
// Context will be cached for all test cases and classes
// Same cached Context is used for all test cases and test classes
// it is not reloaded

@ContextConfiguration(locations="classpath:com/accenture/ltt/resources/cst-main-config.xml")
// Following Annotation is used to run each test case in a individual Transaction
// with default strategy as rollback, as service layer is hitting DB layer
// so changes done to database must be undone
//@Rollback(false) can be used at the class level/method level to override the same

@Transactional
public class EmployeeServiceTest {
	@Autowired
	private EmployeeServiceImpl empServiceIMPL;
	@BeforeEach
	public void testMethodBeforeInterceptor() {
		System.out.println("Starting a new Test Method..");
	}
	@AfterEach
	public void testMethodAfterInterceptor() {
		System.out.println("End the Test Method..");
	}
	@Test
	public void testFindAll() throws Exception {
		System.out.println("********* testFindAll() *********");
		Collection<EmployeeBean> empList = empServiceIMPL.getAllEmployeeDetails();
		Assertions.assertTrue(empList != null);
	}
	
	@Test
	@Rollback(false)
	public void testSaveValid() throws Exception {
		System.out.println("********* testSaveValid() *********");
		EmployeeBean bean = new EmployeeBean("MSD","TL", new Date(), 2345.0);
		EmployeeBean bean2 = empServiceIMPL.addEmployee(bean);
		Assertions.assertTrue(bean2!=null);
	}
	@Test
	public void testFindByIdValid() throws Exception {
		System.out.println("********* testFindByIdValid() *********");
		EmployeeBean emp = empServiceIMPL.getEmployeeDetails(1001);
		Assertions.assertTrue(emp != null);
	}
	@Test
	public void testFindByIdInValid() throws Exception {
		System.out.println("********* testFindByIdInValid() *********");
		Assertions.assertThrows(EmployeeNotFoundException.class, ()->empServiceIMPL.getEmployeeDetails(5122));
	}
}

//Remember for all the test cases Spring context will be loaded only once
//to reload the context you have to use dirties context annotation
//refer Spring-Test module documentation
//https://docs.spring.io/spring/docs/4.2.4.RELEASE/spring-framework-reference/html/integration-testing.html
