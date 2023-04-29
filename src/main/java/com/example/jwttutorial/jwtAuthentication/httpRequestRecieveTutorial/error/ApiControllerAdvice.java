package com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import lombok.extern.slf4j.Slf4j;


@RestControllerAdvice
@Slf4j
public class ApiControllerAdvice extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
			HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
		//
		log.error(ex.getMessage(), ex);

		ResponseError re = new ResponseError(statusCode.value(), ex.getMessage());
		return super.handleExceptionInternal(ex, re, headers, statusCode, request);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		//
		log.error(ex.getMessage(), ex);

		ResponseError responseError = new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "サーバ内で予期せぬエラーが発生しました。管理者に問い合わせてください。");
		return new ResponseEntity<Object>(responseError, null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
