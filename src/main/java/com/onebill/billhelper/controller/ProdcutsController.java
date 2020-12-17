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
	@PostMapping("/product")
	public ResponseDTO getProduct(@RequestBody Products product) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.addProducts(product));
		return response;
	}

	@PutMapping("/product")
	public ResponseDTO updateProduct(@RequestBody Products product) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.updateProducts(product));
		return response;
	}

	@DeleteMapping("/{productId}")
	public ResponseDTO removeProduct(@PathVariable int productId) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.removeProducts(productId));
		return response;

	}

	@GetMapping("/products")
	public ResponseDTO getAllProducts() {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.getAllProducts());
		return response;

	}
	

	@GetMapping("/{productId}")
	public ResponseDTO getProductById(@PathVariable int productId) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.getProductById(productId));
		return response;

	}


}
