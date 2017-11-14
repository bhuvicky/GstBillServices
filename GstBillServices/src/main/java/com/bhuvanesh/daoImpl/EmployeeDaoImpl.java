package com.bhuvanesh.daoImpl;

import org.jongo.Jongo;

import com.bhuvanesh.constants.MongoConstants;
import com.bhuvanesh.dao.IEmployeeDao;
import com.bhuvanesh.utils.MongoUtils;
import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Employee;
import com.mongodb.WriteResult;

public class EmployeeDaoImpl implements IEmployeeDao{

	@Override
	public BaseResponse saveEmpDetails(Employee emp) {
		WriteResult wr = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.COLLECTION_EMPLOYEE_DETIALS)
				.insert(emp);
		
		if (wr != null && wr.getN() != -1) {
			BaseResponse response = new BaseResponse();
			response.setMessage("success emp saved");
			response.setStatusCode(200);
			return response;
		}
		
		return null;
	}

	@Override
	public Employee getEmpForAge(int age) {
		return new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.COLLECTION_EMPLOYEE_DETIALS)
				.findOne("{age:#}", age).as(Employee.class);
	}

}
