package com.accenture.ltt.dao;

import com.accenture.ltt.business.bean.LoginBean;

public class LoginDAO {

	public String validateLogin(LoginBean loginBean){
		
		String uName = loginBean.getUserName();
		String password = loginBean.getPassword();
		
		if(uName.equals("MSD") && password.equals("MSD@123")){
			return "success";
		}
		else{
			return "faliure";
		}
	}
}
