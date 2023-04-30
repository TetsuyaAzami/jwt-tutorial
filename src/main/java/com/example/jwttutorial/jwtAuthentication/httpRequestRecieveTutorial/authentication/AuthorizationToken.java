package com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

public class AuthorizationToken {

	private final String value;

	public AuthorizationToken(final String authenticationHeader) {
		//
		if (!StringUtils.hasText(authenticationHeader))
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "ログインしてください");
		if (authenticationHeader.indexOf("Bearer") != 0)
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "トークンの形式が不正です");

		this.value = authenticationHeader.substring(7);
	}

	public String value() {
		//
		return this.value;
	}
}
