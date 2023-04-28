package com.example.jwttutorial.jwtAuthentication.calculator;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.jwttutorial.jwtAuthentication.tokenManipulator.AuthTokenVerifier;

public class AddCalculator {

	private AuthTokenVerifier verifier;
	private AddOperator addOperator;

	public AddCalculator(AuthTokenVerifier verifier, AddOperator addOperator) {
		this.verifier = verifier;
		this.addOperator = addOperator;
	}

	public void calculate(int left, int right, String token) {
		//
		DecodedJWT decodedJwt = verifier.verifyToken(token);
		int result = addOperator.operate(left, right);
		System.out.println(decodedJwt.getClaim("name").asString() + "さんが依頼したオペレーションの結果は" + result + "です");
	}
}
