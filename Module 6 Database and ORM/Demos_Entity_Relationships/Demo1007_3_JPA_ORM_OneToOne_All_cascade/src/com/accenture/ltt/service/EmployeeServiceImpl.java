package com.accenture.ltt.service;

import com.accenture.ltt.businessbean.AssetBean;
import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.utility.Factory;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void removeEmployeeAndAsset(EmployeeBean employee) throws Exception {
		EmployeeDAO employeeDAO = Factory.createEmployeeDAO();
		try {
			employeeDAO.removeEmployeeAndAsset(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	public Integer insertAssetWithEmployee(EmployeeBean employeeBean, AssetBean assetBean) throws Exception {
		int employeeId = 0;
		EmployeeDAO employeeDAO = Factory.createEmployeeDAO();
		try {
			employeeId = employeeDAO.insertAssetWithEmployee(employeeBean, assetBean);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return employeeId;
	}
}
