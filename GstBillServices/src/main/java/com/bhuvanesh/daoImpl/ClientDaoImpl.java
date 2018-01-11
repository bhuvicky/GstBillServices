package com.bhuvanesh.daoImpl;

import java.util.Iterator;
import java.util.List;

import org.jongo.Aggregate;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.bhuvanesh.constants.MongoConstants;
import com.bhuvanesh.dao.IClientDao;
import com.bhuvanesh.utils.AppUtils;
import com.bhuvanesh.utils.MongoUtils;
import com.bhuvanesh.utils.SearchUtil;
import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Client;
import com.bhuvanesh.vo.ClientListRequest;
import com.mongodb.WriteResult;

public class ClientDaoImpl implements IClientDao {
	

	@Override
	public BaseResponse updateClientDetails(Client client) {
		long id = client.getClientId();
		if (id == 0)
			client.setClientId(AppUtils.getNewId("clientId"));
		
		// update query with clientId field and upsert true, then no need of unique index on clientId field
		WriteResult wr1 = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.COLLECTION_CLIENT)
				.update("{clientId:#}", client.getClientId()).upsert().with(client);
		
		return AppUtils.getBaseResponse(wr1.getN(), id);
	}

	@Override
	public BaseResponse deleteClient(long id) {
		WriteResult wr1 = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.COLLECTION_CLIENT)
				.remove("{clientId:#}", id);
		return AppUtils.getBaseResponse(wr1.getN(), -1);
	}

	@Override
	public List<Client> getClientList(ClientListRequest request) {
MongoCollection coll = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.COLLECTION_CLIENT);
		
		Aggregate aggregate = null;
		if (request.getSearchType() == ClientListRequest.SEARCH_BY_NAME) {
			aggregate = coll.aggregate("{$match : {name : {$regex : #}}}", 
					SearchUtil.generateSearchString(request.getName()));
		} else if (request.getSearchType() == ClientListRequest.SEARCH_BY_MOBILE) {
			aggregate = coll.aggregate("{$match : {phoneNoList : {$regex : #}}}", 
					SearchUtil.generateSearchString(request.getMobileNo()));
		} else {
			aggregate = coll.aggregate("{$match : {}}");
		}
		
		Iterator<Client> iter = aggregate.and("{$sort : {name : 1}}")
				.and("{$skip : #}", request.getFrom())
				.and("{$limit : #}", request.getPageLimit())
				.as(Client.class);
		return AppUtils.iteratorToList(iter);
	}

}
