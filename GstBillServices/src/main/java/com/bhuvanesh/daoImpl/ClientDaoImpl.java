package com.bhuvanesh.daoImpl;

import java.util.Iterator;
import java.util.List;

import org.jongo.Jongo;

import com.bhuvanesh.constants.MongoConstants;
import com.bhuvanesh.dao.IClientDao;
import com.bhuvanesh.utils.AppUtils;
import com.bhuvanesh.utils.MongoUtils;
import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Client;
import com.mongodb.WriteResult;

public class ClientDaoImpl implements IClientDao {

	@Override
	public BaseResponse updateClientDetails(Client client) {
		long id = client.clientId;
		if (id == 0)
			client.clientId = AppUtils.getNewId("clientId");
		
		// update query with clientId field and upsert true, then no need of unique index on clientId field
		WriteResult wr1 = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.COLLECTION_CLIENT)
				.update("{clientId:#}", client.clientId).upsert().with(client);
		
		return AppUtils.getBaseResponse(wr1.getN(), id);
	}

	@Override
	public BaseResponse deleteClient(long id) {
		WriteResult wr1 = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.COLLECTION_CLIENT)
				.remove("{clientId:#}", id);
		return AppUtils.getBaseResponse(wr1.getN(), -1);
	}

	@Override
	public List<Client> getClientList(String sortBy, int from) {
		Iterator<Client> clientIterator = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.COLLECTION_CLIENT)
				.find().sort("{firstName : 1}").limit(from).skip(from > 10 ? from : 0).as(Client.class).iterator();
		return AppUtils.iteratorToList(clientIterator);
	}
}
