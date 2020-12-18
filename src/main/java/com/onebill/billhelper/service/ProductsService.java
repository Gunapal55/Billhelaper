package com.onebill.billhelper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onebill.billhelper.dto.ProductsDTO;

@Service
public interface ProductsService {

	public ProductsDTO addProduct(ProductsDTO product);

	public ProductsDTO updateProduct(ProductsDTO product);

	public ProductsDTO removeProduct(ProductsDTO product);

	public List<ProductsDTO> getAllProduct();

	public List<ProductsDTO> getProduct(ProductsDTO product);

}
