package com.example.jwttutorial.jwtAuthentication.authentication;

import com.example.jwttutorial.jwtAuthentication.tokenManipulator.AuthTokenProducer;

public class SimpleIdProvider {

	private UserAuthenticator authenticator;

	private AuthTokenProducer tokenProducer;

	public SimpleIdProvider(UserAuthenticator authenticator, AuthTokenProducer tokenProducer) {
		this.authenticator = authenticator;
		this.tokenProducer = tokenProducer;
	}

	public String publishToken(String id, String password) {
		//
		User authenticatedUser = this.authenticator.authenticate(id, password);
		return this.tokenProducer.generateToken(authenticatedUser);
	}
}
