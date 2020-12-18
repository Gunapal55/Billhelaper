package com.onebill.billhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.billhelper.dao.ProductsDAO;
import com.onebill.billhelper.dto.ProductsDTO;
import com.onebill.billhelper.exception.BillhelperException;

@Service
public class ProductsServiceImplementation implements ProductsService {

	@Autowired
	private ProductsDAO productsdao;

	@Override
	public ProductsDTO addProduct(ProductsDTO product) {
		System.out.println();
		ProductsDTO addPro = productsdao.addProduct(product);
		if (addPro != null) {
			return addPro;
		} else {
			throw new BillhelperException("Record already exists");
		}
	}

	@Override
	public ProductsDTO removeProduct(ProductsDTO product) {

		ProductsDTO remPro = productsdao.removeProduct(product);
		if (remPro != null) {

			return remPro;

		} else {
			throw new BillhelperException("No matching data found to remove");

		}
	}

	@Override
	public ProductsDTO updateProduct(ProductsDTO product) {
		ProductsDTO updPro = productsdao.updateProduct(product);
		if (updPro != null) {

			return updPro;

		} else {
			throw new BillhelperException("No matching record found for update");

		}
	}

	@Override
	public List<ProductsDTO> getAllProduct() {
		List<ProductsDTO> proList = productsdao.getAllProduct();
		if (proList != null) {

			return proList;

		} else {
			throw new BillhelperException("No products found");

		}
	}

	@Override
	public List<ProductsDTO> getProduct(ProductsDTO product) {
		List<ProductsDTO> getPro = productsdao.getProduct(product);
		if (getPro != null) {

			return getPro;

		} else {
			throw new BillhelperException("No matching data found to fetch");

		}
	}

}
