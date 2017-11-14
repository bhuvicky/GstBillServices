package com.bhuvanesh.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jongo.Jongo;

import com.bhuvanesh.constants.AppConstants;
import com.bhuvanesh.constants.MongoConstants;
import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.UniqueIdVO;

public class AppUtils {

	public static BaseResponse getBaseResponse(int dbOperationStatus, long id) {
		BaseResponse response = new BaseResponse();
		if (dbOperationStatus != -1) {
			if (id > 0) {
				response.setStatusCode(AppConstants.STATUS_CODE_SUCCESS);
				response.setMessage(AppConstants.RESPONSE_MSG_UPDATE);
			} else if (id == 0){
				response.setStatusCode(AppConstants.STATUS_CODE_SUCCESS);
				response.setMessage(AppConstants.RESPONSE_MSG_INSERT);
			} else {
				response.setStatusCode(AppConstants.STATUS_CODE_SUCCESS);
				response.setMessage(AppConstants.RESPONSE_MSG_DELETE);
			}
		} else {
			response.setStatusCode(AppConstants.STATUS_CODE_ERROR);
			response.setMessage(AppConstants.RESPONSE_MSG_ERROR);
		}
		return response;
	}
	
	public static long getNewId(String idSeqName) {
		UniqueIdVO uniqueId = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.COLLECTION_COUNTER)
				.findAndModify("{idName:#}", idSeqName).with("{ $inc: {seq: 1} }").as(UniqueIdVO.class);
		return uniqueId.seq;
	}
	
	public static <T> List<T> iteratorToList(Iterator<T> itr) {
		List<T> list = new ArrayList();
		
		if (itr != null) {
			while(itr.hasNext()) {
				list.add(itr.next());
			}
		}
		return list;
	}
}
