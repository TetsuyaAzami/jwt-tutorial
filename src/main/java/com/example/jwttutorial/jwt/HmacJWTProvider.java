package com.example.jwttutorial.jwt;

import java.time.OffsetDateTime;
import java.util.UUID;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class HmacJWTProvider {
	private String secretkey;

	public HmacJWTProvider(String secretkey) {
		this.secretkey = secretkey;
	}

	public String generateToken() {
		//
		Algorithm alg = Algorithm.HMAC256(this.secretkey);

		String token = JWT.create().withIssuer(this.getClass().getSimpleName())
				.withSubject("ID12345")
				.withExpiresAt(OffsetDateTime.now().plusMinutes(60).toInstant())
				.withIssuedAt(OffsetDateTime.now().toInstant())
				.withJWTId(UUID.randomUUID().toString()).withClaim("email", "id123459@example.com")
				.withArrayClaim("groups", new String[] {"member", "admin"}).sign(alg);

		return token;
	}
	// public static void main(String[] args) {
	// 	//
	// 	String secretKey = System.getenv("SECRET_KEY");
	// 	System.out.println();
	// 	System.out.println(new HmacJWTProvider(secretKey).generateToken());
	// }
}
