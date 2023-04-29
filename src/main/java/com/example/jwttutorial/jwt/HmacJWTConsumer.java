package com.example.jwttutorial.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class HmacJWTConsumer {
	private String secretKey;

	public HmacJWTConsumer(String secretKey) {
		this.secretKey = secretKey;
	}

	public DecodedJWT verifyToken(String token) {
		//
		Algorithm alg = Algorithm.HMAC256(secretKey);

		JWTVerifier verifier = JWT.require(alg).withIssuer(HmacJWTProvider.class.getSimpleName())
				.acceptExpiresAt(5).build();

		try {
			return verifier.verify(token);
		} catch (JWTVerificationException e) {
			System.out.println("jwtトークンの検証に失敗しました");
			throw e;
		}
	}

	// public static void main(String[] args) {
	// 	//
	// 	String secretKey = System.getenv("SECRET_KEY");
	// 	DecodedJWT jwt = new HmacJWTConsumer(secretKey)
	// 			.verifyToken(new HmacJWTProvider(secretKey).generateToken());

	// 	System.out.println("------Decoded JWT ---------");
	// 	System.out.println("alg: " + jwt.getAlgorithm());
	// 	System.out.println("content-type: " + jwt.getContentType());
	// 	System.out.println("typ: " + jwt.getType());
	// 	System.out.println("issuer: " + jwt.getIssuer());
	// 	System.out.println("subject: " + jwt.getSubject());
	// 	System.out.println("expiresAt:" + jwt.getExpiresAt());
	// 	System.out.println("issuerAt:" + jwt.getIssuedAt());
	// 	System.out.println("JWT-ID:" + jwt.getId());
	// 	System.out.println("email:" + jwt.getClaim("email").asString());
	// 	System.out.println("groups:" + jwt.getClaim("groups").asList(String.class).stream()
	// 			.collect(Collectors.joining(",")));
	// }
}
