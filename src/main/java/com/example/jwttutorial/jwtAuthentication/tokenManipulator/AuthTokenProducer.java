package com.example.jwttutorial.jwtAuthentication.tokenManipulator;

import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.jwttutorial.jwtAuthentication.authentication.User;

@Component
public class AuthTokenProducer {

	private String secretKey = System.getenv("SECRET_KEY");

	public String generateToken(User user) {
		//
		Algorithm alg = Algorithm.HMAC256(this.secretKey);

		String token =
				JWT.create().withIssuer(this.getClass().getSimpleName()).withSubject(user.getId())
						.withExpiresAt(OffsetDateTime.now().plusDays(60).toInstant())
						.withIssuedAt(OffsetDateTime.now().toInstant())
						.withJWTId(UUID.randomUUID().toString()).withClaim("name", user.getName())
						.sign(alg);

		return "Bearer " + token;
	}

}
