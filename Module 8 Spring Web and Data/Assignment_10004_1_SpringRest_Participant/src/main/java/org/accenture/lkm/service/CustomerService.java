package org.accenture.lkm.service;

import java.util.List;

import org.accenture.lkm.business.bean.CustomerBean;

public interface CustomerService {
	List<CustomerBean> findByCustomerType(String customerType);
}
