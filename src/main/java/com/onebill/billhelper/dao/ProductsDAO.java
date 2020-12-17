package com.onebill.billhelper.dao;

import java.util.List;

import com.onebill.billhelper.entity.Products;

public interface ProductsDAO {

	public Products addProduct(Products product);
	
	public Products updateProduct(Products product);
	
	public Products removeProduct(int productId);
	
	public List<Products> getAllProduct();
	
	public Products getProductById(int productId);
	
}
