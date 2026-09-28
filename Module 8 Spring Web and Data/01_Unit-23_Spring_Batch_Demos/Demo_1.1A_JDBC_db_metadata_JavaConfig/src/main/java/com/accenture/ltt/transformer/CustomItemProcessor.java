package com.accenture.ltt.transformer;

import org.springframework.batch.item.ItemProcessor;

import com.accenture.ltt.dto.Employee;

public class CustomItemProcessor implements ItemProcessor<Employee, Employee> {
 
    public Employee process(Employee item) {
    	System.out.println("Processing......"+item);
        return item;
    }
}