package com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.authentication;

import java.lang.reflect.Method;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.jwttutorial.jwtAuthentication.tokenManipulator.AuthTokenVerifier;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthorizationInterceptor implements HandlerInterceptor {

	private AuthTokenVerifier tokenVerifier = new AuthTokenVerifier(System.getenv("SECRET_KEY"));

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//
		if (!(handler instanceof HandlerMethod))
			return true;
		Method method = ((HandlerMethod) handler).getMethod();
		if (AnnotationUtils.findAnnotation(method, NonAuthorize.class) != null)
			return true;

		try {
			DecodedAuthorizationToken decodedToken = authorize(request);
			request.setAttribute(DecodedAuthorizationToken.REQUEST_KEY, decodedToken);
		} catch (JWTVerificationException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}

		return true;
	}

	private DecodedAuthorizationToken authorize(HttpServletRequest request) {
		//
		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		AuthorizationToken token = new AuthorizationToken(authorizationHeader);
		return this.tokenVerifier.verifyToken(token.value());
	}
}
