package com.bhuvanesh.dao;

import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Employee;

public interface IEmployeeDao {

	BaseResponse saveEmpDetails(Employee emp);
	
	Employee getEmpForAge(int age);
}
