package com.bhuvanesh.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhuvanesh.services.ClientServices;
import com.bhuvanesh.services.EmployeeServices;
import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Client;
import com.bhuvanesh.vo.Employee;

@RestController
public class GstBillController {

	EmployeeServices services = new EmployeeServices();
	
	ClientServices cServices = new ClientServices();
	
	@RequestMapping(value = "/saveEmp", method = RequestMethod.POST, headers = "Accept=application/json")
	public BaseResponse saveEmpDetails(@RequestBody Employee emp) {
		return services.saveEmpDetails(emp);
	}
	
	@RequestMapping(value = "/getEmp",  method = RequestMethod.GET, headers = "Accept=application/json")
	public Employee getEmpForAge(@RequestParam(value = "age") int age) {
		System.out.println("log controller hit");
		return services.getEmp(age);
	}
	
	@RequestMapping(value = "/updateClient", method = RequestMethod.POST, headers = "Accept=application/json")
	public BaseResponse updateClientDetails(@RequestBody Client emp) {
		return cServices.updateClientDetails(emp);
	}
	
	@RequestMapping(value = "/deleteClient", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public BaseResponse deleteClient(@RequestParam(value = "clientId") long id) {
		return cServices.deleteClient(id);
	}	 
	
}
