package com.onebill.billhelper.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onebill.billhelper.dto.ResponseDTO;

@RestControllerAdvice
@CrossOrigin(origins= "*")
public class ControllerAdvice {

	
	@ExceptionHandler
	public ResponseDTO handler(Exception e) {
		ResponseDTO dto = new ResponseDTO();
		dto.setError(true);
		dto.setData(e.getMessage());
		return dto;
	}
}
	

