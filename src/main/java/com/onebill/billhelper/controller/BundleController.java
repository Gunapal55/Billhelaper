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
import com.onebill.billhelper.entity.Bundle;
import com.onebill.billhelper.entity.BundleDetails;
import com.onebill.billhelper.service.BundleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product/bundle")
public class BundleController {

	@Autowired
	private BundleService service;

	@ResponseBody
	@PostMapping("/bundle")
	public ResponseDTO getBundle(@RequestBody Bundle bundle) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.createBundle(bundle));
		return response;
	}

	@PutMapping("/bundle")
	public ResponseDTO updateProduct(@RequestBody Bundle bundle) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.updateBundle(bundle));
		return response;
	}

	@DeleteMapping("/{bundleId}")
	public ResponseDTO removeProduct(@PathVariable int bundleId) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.removeBundle(bundleId));
		return response;

	}

	@GetMapping("/bundle")
	public ResponseDTO getAllProducts() {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.getAllBundle());
		return response;

	}

	@GetMapping("/{bundleId}")
	public ResponseDTO getProductById(@PathVariable int bundleId) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.getBundleById(bundleId));
		return response;
	}

	@ResponseBody
	@PostMapping("/details")
	public ResponseDTO getBundleDetails(@RequestBody BundleDetails bundleDetail) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.addBundleDetails(bundleDetail));
		return response;
	}
	
	@PutMapping("/details")
	public ResponseDTO BundleDetails(@RequestBody BundleDetails bundleDetail) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.updateBundleDetails(bundleDetail));
		return response;
	}
	@DeleteMapping("/{bundleDetailId}")
	public ResponseDTO removeBundleDetails(@PathVariable int bundleDetailId) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.removeBundleDetails(bundleDetailId));
		return response;

	}

	@GetMapping("/detail")
	public ResponseDTO getAllBundleDetail() {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.getAllBundleDetails());
		return response;

	}
	@GetMapping("/{bundleDetailId}")
	public ResponseDTO getBundleDetailById(@PathVariable int bundleDetailId) {
		ResponseDTO response = new ResponseDTO();
		response.setData(service.getBundleDetailById(bundleDetailId));
		return response;
	}


	
}
