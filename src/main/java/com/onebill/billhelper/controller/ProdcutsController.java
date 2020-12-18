package com.onebill.billhelper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.billhelper.dto.ProductsDTO;
import com.onebill.billhelper.dto.ResponseDTO;
import com.onebill.billhelper.entity.Products;
import com.onebill.billhelper.service.ProductsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProdcutsController {

	@Autowired
	private ProductsService service;

	@ResponseBody
	@PostMapping
	public ResponseDTO getProduct(@RequestBody ProductsDTO product) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.addProduct(product));
		return response;
	}

	@PutMapping
	public ResponseDTO updateProduct(@RequestBody ProductsDTO product) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.updateProduct(product));
		return response;
	}

	@DeleteMapping
	public ResponseDTO removeProduct(@RequestBody ProductsDTO product) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.removeProduct(product));
		return response;

	}	

	@GetMapping("/products")
	public ResponseDTO getAllProducts() {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.getAllProduct());
		return response;

	}
	
	@GetMapping
	public ResponseDTO getProductById(@RequestBody ProductsDTO product) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.getProduct(product));
		return response;

	}


}
