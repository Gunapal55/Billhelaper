package com.onebill.billhelper.dao;

import java.util.List;

import com.onebill.billhelper.dto.ProductsDTO;

public interface ProductsDAO {

	public ProductsDTO addProduct(ProductsDTO product);
	
	public ProductsDTO updateProduct(ProductsDTO product);
	
	public ProductsDTO removeProduct(ProductsDTO product);
	
	public List<ProductsDTO> getAllProduct();
	
	public List<ProductsDTO> getProduct(ProductsDTO product);
	
}
