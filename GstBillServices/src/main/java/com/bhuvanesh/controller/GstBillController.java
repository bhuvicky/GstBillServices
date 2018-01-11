package com.bhuvanesh.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhuvanesh.services.ClientServices;
import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Client;
import com.bhuvanesh.vo.ClientListRequest;

@RestController
public class GstBillController {

	ClientServices clientServices = new ClientServices();
			
	@RequestMapping(value = "/updateClient", method = RequestMethod.POST, headers = "Accept=application/json")
	public BaseResponse updateClientDetails(@RequestBody Client emp) {
		return clientServices.updateClientDetails(emp);
	}
	
	@RequestMapping(value = "/deleteClient", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public BaseResponse deleteClient(@RequestParam(value = "clientId") long id) {
		return clientServices.deleteClient(id);
	}	 

	@RequestMapping(value = "/getClientList", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Client> getClientList(@RequestBody ClientListRequest request) {
		return clientServices.getClientList(request);
	}	
}
