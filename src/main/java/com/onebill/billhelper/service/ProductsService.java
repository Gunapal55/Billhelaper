package com.onebill.billhelper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onebill.billhelper.entity.Products;

@Service
public interface ProductsService {

	public Products addProducts(Products product);	
	public Products removeProducts(int productId);
	public Products updateProducts(Products product);
	public List<Products> getAllProducts();
	public Products getProductById(int productId);
	
	
}
