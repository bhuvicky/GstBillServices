package com.bhuvanesh.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhuvanesh.services.ProductServices;
import com.bhuvanesh.utils.SearchUtil;
import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	ProductServices productServices = new ProductServices();
	
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	public BaseResponse updateProductDetails(@RequestBody Product prod) {
		return productServices.updateProductDetails(prod);
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public BaseResponse deleteProduct(@RequestParam(value = "productId") long id) {
		return productServices.deleteProduct(id);
	}	 

	@RequestMapping(value = "/getProductList", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Product> getProductList(@RequestParam(value = "productName") String query) {
		return productServices.getProductList(SearchUtil.splitSearchWords(query));
	}
}
