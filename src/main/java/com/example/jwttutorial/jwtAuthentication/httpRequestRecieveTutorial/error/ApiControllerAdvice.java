package com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiControllerAdvice extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
			HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
		//
		ResponseError re = new ResponseError(statusCode.value(), ex.getMessage());
		return super.handleExceptionInternal(ex, re, headers, statusCode, request);
	}
}
