package org.accenture.lkm.dao;

import java.util.List;

import org.accenture.lkm.business.bean.CustomerBean;

public interface CustomerDAO {
	public List<CustomerBean> findByCustomerType(String customerType);
}