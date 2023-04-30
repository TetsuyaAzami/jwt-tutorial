package com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.authentication;

import com.auth0.jwt.interfaces.DecodedJWT;

public class DecodedAuthorizationToken {

	private DecodedJWT decodedJWT;

	public static final String REQUEST_KEY = "decodedToken";

	public DecodedAuthorizationToken(DecodedJWT decodedJWT) {
		//
		this.decodedJWT = decodedJWT;
	}

	public DecodedJWT token() {
		//
		return this.decodedJWT;
	}

	public String userId() {
		//
		return this.decodedJWT.getSubject();
	}

	public String password() {
		//
		return this.decodedJWT.getClaim("password").asString();
	}

	public String name() {
		//
		return this.decodedJWT.getClaim("name").asString();
	}
}
