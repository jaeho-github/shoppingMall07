package com.model2.mvc.service.product;

import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;

public interface ProductDAO {
	
	public void insertProduct(Product product) throws Exception;

	public Product findProduct(int prodNo) throws Exception;

	public List<Product> getProductList(Search search) throws Exception;

	public void updateProduct(Product product) throws Exception;
	
	// 게시판 Page 처리를 위한 전체 Row(totalCount)  return
	public int getTotalCount(Search search) throws Exception;
	
}