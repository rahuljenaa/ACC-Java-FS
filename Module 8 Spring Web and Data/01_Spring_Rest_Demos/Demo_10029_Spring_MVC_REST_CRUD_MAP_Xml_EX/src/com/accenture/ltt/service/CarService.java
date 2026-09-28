package com.accenture.ltt.service;

import java.util.Collection;

import com.accenture.ltt.bussiness.bean.CarBean;

public interface CarService {

	Collection<CarBean> getAllCar();

	CarBean getCarDetailsById(int id);

	Integer addCar(CarBean car);

	CarBean updateCar(CarBean car);

	CarBean removeCar(int id);

}