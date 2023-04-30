package com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.authentication;

import com.auth0.jwt.interfaces.DecodedJWT;

public class DecodedAuthorizationToken {

	private DecodedJWT decodedJWT;

	public DecodedAuthorizationToken(DecodedJWT decodedJWT) {
		//
		this.decodedJWT = decodedJWT;
	}

	public String token() {
		//
		return this.decodedJWT.getToken();
	}
}
