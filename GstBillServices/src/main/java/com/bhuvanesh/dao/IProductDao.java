package com.bhuvanesh.dao;

import java.util.List;

import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.ClientListRequest;
import com.bhuvanesh.vo.Product;

public interface IProductDao {
	
	BaseResponse updateProductDetails(Product product);
	BaseResponse deleteProduct(long id);
	List<Product> getProductList(String query);
}
