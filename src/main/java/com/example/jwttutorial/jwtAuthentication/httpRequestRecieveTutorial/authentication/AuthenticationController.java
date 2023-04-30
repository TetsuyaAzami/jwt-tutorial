package com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jwttutorial.jwtAuthentication.authentication.User;
import com.example.jwttutorial.jwtAuthentication.authentication.UserAuthenticator;
import com.example.jwttutorial.jwtAuthentication.tokenManipulator.AuthTokenProducer;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

	private UserAuthenticator userAuthenticator;

	private AuthTokenProducer tokenProducer;

	@Autowired
	public AuthenticationController(final UserAuthenticator userAuthenticator,
			final AuthTokenProducer tokenProducer) {
		this.userAuthenticator = userAuthenticator;
		this.tokenProducer = tokenProducer;
	}

	@PostMapping(value = "/auth", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> jwtAuthentication(@RequestBody User user) {
		//
		User authenticatedUser =
				this.userAuthenticator.authenticate(user.getId(), user.getPassword());

		String generatedToken = tokenProducer.generateToken(authenticatedUser);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.AUTHORIZATION, generatedToken);

		return new ResponseEntity<String>("You are Authorized!!", httpHeaders, HttpStatus.OK);
	}
}
