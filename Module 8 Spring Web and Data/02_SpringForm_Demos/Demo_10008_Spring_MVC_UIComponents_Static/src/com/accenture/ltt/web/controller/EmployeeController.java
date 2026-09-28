package com.accenture.ltt.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.ltt.business.bean.EmployeeBean;

@Controller
public class EmployeeController {

	// Default method is Get
	@RequestMapping("/loadEmployeeRegistrationPage.html")
	public ModelAndView showRegistrationPage() {
		return new ModelAndView("Registration", "employeeBean", new EmployeeBean());
	}

	@RequestMapping(value = "/registration.html", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("employeeBean") EmployeeBean employeeBean, HttpServletRequest request) {
		System.out.println("*******************************");
		System.out.println(employeeBean);
		System.out.println(request.getAttribute("employeeBean"));
		System.out.println("*******************************");
		
		System.out.println();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("RegistrationSuccess");
		modelAndView.addObject("message", "Welcome: " + employeeBean.getName());
		return modelAndView;
	}
}