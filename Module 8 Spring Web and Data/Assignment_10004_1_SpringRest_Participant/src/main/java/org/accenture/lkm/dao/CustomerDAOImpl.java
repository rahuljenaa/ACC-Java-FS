package org.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.accenture.lkm.business.bean.CustomerBean;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	
	private static List<CustomerBean> customerBeans=null;
	
	static{
		customerBeans=new ArrayList<CustomerBean>();
		customerBeans.add(new CustomerBean(1001,"JAS","Gold",20000));
		customerBeans.add(new CustomerBean(1002,"MSD","Silver",30000));
		customerBeans.add(new CustomerBean(1003,"Jack","Gold",40000));
		customerBeans.add(new CustomerBean(1004,"Justin","Platnium",50000));
		customerBeans.add(new CustomerBean(1005,"Joseph","Gold",60000));
	}

	@Override
	public List<CustomerBean> findByCustomerType(String customerType) {
		return customerBeans
				.stream()
				.filter(customerBean->customerBean.getCustomerType()
						.equals(customerType)).collect(Collectors.toList());
	}
}
