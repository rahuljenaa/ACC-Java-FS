package com.accenture.ltt.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.bussiness.bean.CarBean;
import com.accenture.ltt.dao.CarDAO;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDAO carDAO;
	
	public Collection<CarBean> getAllCar(){
		return carDAO.getAllCars();			
	}
	
	public CarBean getCarDetailsById(int id){
		return carDAO.getCarDetailsById(id);
	}
	
	public Integer addCar(CarBean car){
		return carDAO.addCar(car);
	}
	
	public CarBean updateCar (CarBean car){
		return carDAO.updateCar(car);
	}
	
	public CarBean removeCar (int id){
		return carDAO.carEmployee(id);
	}
	
}
