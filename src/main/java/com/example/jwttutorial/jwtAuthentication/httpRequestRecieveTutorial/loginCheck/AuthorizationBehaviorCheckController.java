package com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.loginCheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.authentication.NonAuthorize;

@RestController
@RequestMapping("/api/v1")
public class AuthorizationBehaviorCheckController {

	@RequestMapping("/forEveryone")
	@NonAuthorize
	public ResponseEntity<String> everyoneCanAccess() {
		//
		return new ResponseEntity<String>("not authorized but OK!", HttpStatus.OK);
	}

	@RequestMapping("/forAuthorized")
	public ResponseEntity<String> authorizedOneCanAccess() {
		//
		return new ResponseEntity<String>("authorized OK!", HttpStatus.OK);
	}
}
