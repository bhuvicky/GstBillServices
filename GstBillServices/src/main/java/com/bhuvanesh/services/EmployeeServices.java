package com.bhuvanesh.services;

import org.springframework.web.bind.annotation.RequestBody;

import com.bhuvanesh.dao.IEmployeeDao;
import com.bhuvanesh.daoImpl.EmployeeDaoImpl;
import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Employee;
public class EmployeeServices {

	IEmployeeDao dao = new EmployeeDaoImpl();
	
	public BaseResponse saveEmpDetails(Employee emp) {
		return dao.saveEmpDetails(emp);
	}
	
	public Employee getEmp(int age) {
		return dao.getEmpForAge(age);
	}
	
	
}
