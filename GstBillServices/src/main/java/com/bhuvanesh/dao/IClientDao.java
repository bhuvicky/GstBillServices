package com.bhuvanesh.dao;

import java.util.List;

import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Client;
import com.bhuvanesh.vo.ClientListRequest;

public interface IClientDao {
	
	BaseResponse updateClientDetails(Client client);
	BaseResponse deleteClient(long id);
	List<Client> getClientList(ClientListRequest request);
	
}
