package com.example.jwttutorial.jwtAuthenrication.tokenManipulator;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class AuthTokenVerifier {

	private JWTVerifier verifier;

	public AuthTokenVerifier(String secretKey) {
		Algorithm alg = Algorithm.HMAC256(secretKey);
		this.verifier = JWT.require(alg).withIssuer(AuthTokenProducer.class.getSimpleName())
				.acceptExpiresAt(5).build();
	}

	public DecodedJWT verifyToken(String token) {
		//
		try {
			return this.verifier.verify(token);
		} catch (JWTVerificationException ex) {
			System.out.println("authentication failed");
			throw ex;
		}
	}
}
