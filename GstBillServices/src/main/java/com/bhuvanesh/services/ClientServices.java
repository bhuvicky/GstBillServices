package com.bhuvanesh.services;

import java.util.List;

import com.bhuvanesh.dao.IClientDao;
import com.bhuvanesh.daoImpl.ClientDaoImpl;
import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Client;
import com.bhuvanesh.vo.ClientListRequest;

public class ClientServices {

	IClientDao dao = new ClientDaoImpl();
	
	public BaseResponse updateClientDetails(Client client) {
		return dao.updateClientDetails(client);
	}
	
	public BaseResponse deleteClient(long id) {
		return dao.deleteClient(id);
	}
	
	public List<Client> getClientList(ClientListRequest request) {
		return dao.getClientList(request);
	}
	
}
