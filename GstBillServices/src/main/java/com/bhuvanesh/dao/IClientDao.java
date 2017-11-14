package com.bhuvanesh.dao;

import java.util.List;

import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Client;

public interface IClientDao {
	
	BaseResponse updateClientDetails(Client client);
	BaseResponse deleteClient(long id);
	List<Client> getClientList(String sortBy, int from);
	
}
