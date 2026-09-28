package com.accenture.ltt.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeCmpPK implements Serializable{
	
	private Integer id;
	
	private Integer departmentId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentId, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeCmpPK other = (EmployeeCmpPK) obj;
		return Objects.equals(departmentId, other.departmentId) && Objects.equals(id, other.id);
	}
	
	

}
