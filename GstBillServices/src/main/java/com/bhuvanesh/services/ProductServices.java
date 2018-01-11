package com.bhuvanesh.services;

import java.util.List;

import com.bhuvanesh.dao.IProductDao;
import com.bhuvanesh.daoImpl.ProductDaoImpl;
import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Product;

public class ProductServices {
	
	IProductDao dao = new ProductDaoImpl();

	public BaseResponse updateProductDetails(Product Product) {
		return dao.updateProductDetails(Product);
	}
	
	public BaseResponse deleteProduct(long id) {
		return dao.deleteProduct(id);
	}
	
	public List<Product> getProductList(String query) {
		return dao.getProductList(query);
	}
}
