package com.accenture.ltt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.entity.EmployeeEntity;
@Service
public class EmployeeServiceImpl {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	// Step4 to annotate the method with cache instructions
	
	// name element defines name of the cache used.
	// key defines the index value for the cached object.
	// This annotation makes sure that the return value from
	// this method is stored in the cache empCacheSpace with the employeeId as the key
	// and return values as the value.
	// Note: employeeId is retrieved from the parameter
	@Cacheable(value="empCacheSpace", key="#employeeId",unless="#result==null")
	public Optional<EmployeeBean> getEmployeeDetailByEmployeeId(int employeeId) {
		Optional<EmployeeBean> employeeBeanResult = employeeDAO.findById(employeeId).map(employeeEntity -> {
			EmployeeBean employeeBean = new EmployeeBean();
			BeanUtils.copyProperties(employeeEntity, employeeBean);
			return employeeBean;
		});
		return employeeBeanResult;
	}
	
	// Return value is saved in the cache with random key
	@Cacheable(value="empCacheSpace")
	public Collection<EmployeeBean> getEmployeeDetails() {
		Collection<EmployeeEntity> employeeEntities = employeeDAO.findAll();
		List<EmployeeBean> employeeBeans = new ArrayList<>();
		for (EmployeeEntity employeeEntity : employeeEntities) {
			EmployeeBean employeeBean = new EmployeeBean();
			BeanUtils.copyProperties(employeeEntity, employeeBean);
			employeeBeans.add(employeeBean);
		}
		return employeeBeans;
	}

	//2nd to discuss
	// @CachePut is used to put the items in the cache
	// or update the items already in the cache.
	// This annotation makes sure that the return value from
	// this method is stored in the cache empCacheSpace with the employeeId as the key
    // and return values as the Employee object returned by the method after the DB update
	// Note: key is derived from the method's return value,
	// if return type of method would have been int 
	// then it would have format: result
	@CachePut(value="empCacheSpace",key="#result.employeeId") 
	public EmployeeBean addEmployee(EmployeeBean employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		EmployeeEntity emp = employeeDAO.save(employeeEntity);
		BeanUtils.copyProperties(emp, employee);
		return employee;
	}	
	
	
	//3nd to discuss
	// @CachePut is used to put the items in the cache
	// or update the items already in the cache.
	// This annotation makes sure that the return value from
	// this method is stored in the cache empCacheSpace with the employeeId as the key
    // and return values as the Employee object returned by the method after the DB update
	// Note: key is derived from the method parameter received
	@CachePut(value="empCacheSpace",key="#employeeBean.employeeId",unless="#result==null")
	public Optional<EmployeeBean> updateEmployee(EmployeeBean employeeBean) {
		Optional<EmployeeBean> employeeBeanResult= employeeDAO.findById(employeeBean.getEmployeeId()).map(employeeEntity->{
			 BeanUtils.copyProperties(employeeBean,employeeEntity);
			 employeeDAO.save(employeeEntity);
			 return employeeBean;
			 });
		return employeeBeanResult;
	}

	
	
	//4the one
    // This annotation is used to delete the values from the cache.
	// key defines the index/key value for the cached object.
	// When delete method is successfully completed then element is removed from the cache also
	// after removing the same from DB.
	@CacheEvict(value="empCacheSpace",key="#employeeId") 
	public Optional<EmployeeBean> deleteEmployee(int employeeId) {
		Optional<EmployeeBean> employeeBeanResult = employeeDAO.findById(employeeId).map(employeeEntity -> {
			employeeDAO.delete(employeeEntity);
			EmployeeBean employeeBean = new EmployeeBean();
			BeanUtils.copyProperties(employeeEntity, employeeBean);
			return employeeBean;
		});
		return employeeBeanResult;
	}
	
	
	// 5th one
	// Many applications need a  method to clear the whole cache.
	// Purge all the items in the cache 
	@CacheEvict(value="empCacheSpace", allEntries=true)
	public void evictAll(){
		
	}
	// When this method will be invoked then all items in the cache will be purged
}
