package com.example.jwttutorial.jwtAuthentication.tokenManipulator;

import java.time.OffsetDateTime;
import java.util.UUID;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.jwttutorial.jwtAuthentication.authentication.User;

public class AuthTokenProducer {

	private String secretKey;

	public AuthTokenProducer(String secretKey) {
		this.secretKey = secretKey;
	}

	public String generateToken(User user) {
		//
		Algorithm alg = Algorithm.HMAC256(this.secretKey);

		String token =
				JWT.create().withIssuer(this.getClass().getSimpleName()).withSubject(user.getId())
						.withExpiresAt(OffsetDateTime.now().plusDays(60).toInstant())
						.withIssuedAt(OffsetDateTime.now().toInstant())
						.withJWTId(UUID.randomUUID().toString()).withClaim("name", user.getName())
						.sign(alg);

		return token;
	}

}
