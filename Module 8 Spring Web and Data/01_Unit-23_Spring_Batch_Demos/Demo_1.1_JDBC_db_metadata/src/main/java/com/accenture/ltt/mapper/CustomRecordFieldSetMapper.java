package com.accenture.ltt.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.accenture.ltt.dto.Employee;

public class CustomRecordFieldSetMapper implements FieldSetMapper<Employee> {
 
	@Override
    public Employee mapFieldSet(FieldSet fieldSet) throws BindException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Employee employee = new Employee(); 
        employee.setEmployeeName(fieldSet.readString(1));
        employee.setEmployeeId(fieldSet.readInt(0));
        employee.setDesignation(fieldSet.readString(2));
        employee.setDepartmentCode(fieldSet.readInt(4));
        employee.setSalary(fieldSet.readDouble(5));        
        String dateString = fieldSet.readString(3);        
        try {
        	employee.setDateOfJoining(dateFormat.parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }    
        return employee;
    }
}
