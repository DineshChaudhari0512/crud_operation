package com.saksoft.CRUD_Operation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.saksoft.CRUD_Operation.payloads.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resorceNotFountHandler(ResourceNotFoundException ex){
		
		ApiResponse apiresponce=new ApiResponse();
		apiresponce.setStatusCode(HttpStatus.NOT_FOUND.value());
		apiresponce.setMessage(ex.getMessage());
		apiresponce.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ApiResponse>(apiresponce,HttpStatus.NOT_FOUND);
	}

}
