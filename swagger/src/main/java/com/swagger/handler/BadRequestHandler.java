package com.swagger.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.swagger.dto.BasicResponseDto;

@RestControllerAdvice
public class BadRequestHandler {

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<BasicResponseDto> validException(MethodArgumentNotValidException ex) {

		BasicResponseDto response = new BasicResponseDto();
		response.setCode(400);
		response.setMessage(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());

		return ResponseEntity.badRequest().body(response); // 2
	}
}
