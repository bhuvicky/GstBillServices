package com.bhuvanesh.daoImpl;

import java.util.Iterator;
import java.util.List;

import org.jongo.Jongo;

import com.bhuvanesh.constants.MongoConstants;
import com.bhuvanesh.dao.IProductDao;
import com.bhuvanesh.utils.AppUtils;
import com.bhuvanesh.utils.MongoUtils;
import com.bhuvanesh.utils.SearchUtil;
import com.bhuvanesh.vo.BaseResponse;
import com.bhuvanesh.vo.Product;
import com.mongodb.WriteResult;

public class ProductDaoImpl implements IProductDao {

	@Override
	public BaseResponse updateProductDetails(Product product) {
		long id = product.getProductId();
		if (id == 0)
			product.setProductId(AppUtils.getNewId("productId"));
				
		// update query with productId field and upsert true, then no need of unique index on productId field
				WriteResult wr1 = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.COLLECTION_PRODUCT)
						.update("{productId:#}", product.getProductId()).upsert().with(product);
				
				return AppUtils.getBaseResponse(wr1.getN(), id);
	}

	@Override
	public BaseResponse deleteProduct(long id) {
		WriteResult wr1 = new Jongo(MongoUtils.getDB()).getCollection(MongoConstats.COLLECTION_PRODUCT)
				.remove("{productId:#}", id);
		return AppUtils.getBaseResponse(wr1.getN(), -1);
	}

	@Override
	public List<Product> getProductList(String query) {
		Iterator<Product> itr = new Jongo(MongoUtils.getDB()).getCollection(MongoConstants.COLLECTION_PRODUCT)
				.find("{productName : {$regex : #}}", SearchUtil.generateSearchString(query))
				.sort("{productName : 1}").as(Product.class);
		return AppUtils.iteratorToList(itr);
	}

	
}
