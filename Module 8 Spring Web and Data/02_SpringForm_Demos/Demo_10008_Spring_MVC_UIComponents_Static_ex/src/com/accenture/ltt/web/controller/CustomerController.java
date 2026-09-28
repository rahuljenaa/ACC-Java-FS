package com.accenture.ltt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.ltt.business.bean.CustomerBean;

//proper annotation
public class CustomerController {

	// Default method is Get
	// map to page "/loadCustomerRegistrationPage.html")
	public ModelAndView showRegistrationPage() {
		// "Registration", "customerBean", new CustomerBean()
		return null;
	}

	// "/registration.html", default request submission method is post
	// @ModelAttribute("customerBean") to read
	public ModelAndView register(CustomerBean customerBean) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("RegistrationSuccess");
		modelAndView.addObject("message", "Welcome: " + customerBean.getCustomerName());
		return modelAndView;
	}
}