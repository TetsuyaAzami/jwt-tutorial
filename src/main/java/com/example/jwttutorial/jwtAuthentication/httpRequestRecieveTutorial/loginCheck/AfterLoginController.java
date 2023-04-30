package com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.loginCheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jwttutorial.jwtAuthentication.authentication.User;

@RestController
@RequestMapping("/api/v1")
public class AfterLoginController {

	@RequestMapping("/loginuser")
	public ResponseEntity<User> getLoginUser() {
		//
		return new ResponseEntity<User>(new User("1", "dummy", "dummy"), null, HttpStatus.OK);
	}
}
