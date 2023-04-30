package com.example.jwttutorial.jwtAuthentication.calculator;

import com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.authentication.DecodedAuthorizationToken;
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
		DecodedAuthorizationToken decodedToken = this.verifier.verifyToken(token);
		int result = addOperator.operate(left, right);
		System.out.println(decodedToken.token().getClaim("name").asString() + "さんが依頼したオペレーションの結果は" + result + "です");
	}
}
