package com.accenture.ltt.dao;

import com.accenture.ltt.businessbean.AssetBean;
import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeDAO {
	
	 public Integer insertAssetWithEmployee(EmployeeBean employeeBean, AssetBean assetBean) throws Exception;
	
}
