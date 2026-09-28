package com.accenture.ltt.service;

import com.accenture.ltt.businessbean.AssetBean;
import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeService {
	 public void removeEmployeeAndAsset(EmployeeBean employee) throws Exception;
	 public Integer insertAssetWithEmployee(EmployeeBean employeeBean, AssetBean assetBean) throws Exception;
}
