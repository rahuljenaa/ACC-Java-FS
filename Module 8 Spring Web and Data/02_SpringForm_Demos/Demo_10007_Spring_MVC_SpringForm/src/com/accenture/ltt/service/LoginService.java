package com.accenture.ltt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.LoginBean;
import com.accenture.ltt.dao.LoginDAO;

@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;

	public String validateLogin(LoginBean loginBean) {

		return loginDAO.validateLogin(loginBean);

	}

}
