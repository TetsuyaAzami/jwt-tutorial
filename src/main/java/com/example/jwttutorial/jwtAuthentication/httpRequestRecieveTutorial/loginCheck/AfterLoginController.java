package com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.loginCheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jwttutorial.jwtAuthentication.authentication.User;
import com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.authentication.DecodedAuthorizationToken;

@RestController
@RequestMapping("/api/v1")
public class AfterLoginController {

	@RequestMapping("/loginuser")
	public ResponseEntity<User> getLoginUser(@RequestAttribute(
			name = DecodedAuthorizationToken.REQUEST_KEY) DecodedAuthorizationToken decodedToken) {
		//
		return new ResponseEntity<User>(
				new User(decodedToken.userId(), decodedToken.password(), decodedToken.name()), null,
				HttpStatus.OK);
	}
}
