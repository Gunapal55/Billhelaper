package com.onebill.billhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.billhelper.dao.ProductsDAO;
import com.onebill.billhelper.entity.Products;
import com.onebill.billhelper.exception.BillhelperException;

@Service
public class ProductsServiceImplementation implements ProductsService {

	@Autowired
	private ProductsDAO productsdao;

	@Override
	public Products addProducts(Products product) {
		System.out.println();
		Products addPro = productsdao.addProduct(product);
		if (addPro != null) {
			return addPro;
		} else {
			throw new BillhelperException("Record already exists");
		}
	}

	@Override
	public Products removeProducts(int productId) {

		Products remPro = productsdao.removeProduct(productId);
		if (remPro != null) {

			return remPro;

		} else {
			throw new BillhelperException("No matching data found to remove");

		}
	}

	@Override
	public Products updateProducts(Products product) {
		Products updPro = productsdao.updateProduct(product);
		if (updPro != null) {

			return updPro;

		} else {
			throw new BillhelperException("No matching record found for update");

		}
	}

	@Override
	public List<Products> getAllProducts() {
		List<Products> proList = productsdao.getAllProduct();
		if (proList != null) {

			return proList;

		} else {
			throw new BillhelperException("No products found");

		}
	}

	@Override
	public Products getProductById(int productId) {
		Products getPro = productsdao.getProductById(productId);
		if (getPro != null) {

			return getPro;

		} else {
			throw new BillhelperException("No matching data found to fetch");

		}
	}

}
