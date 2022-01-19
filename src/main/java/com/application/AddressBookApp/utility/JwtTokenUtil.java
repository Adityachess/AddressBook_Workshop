package com.application.AddressBookApp.utility;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String SECRET_KEY = "secret";

	/**
	 * 
	 * @param claims
	 * @param subject
	 * @return calling generate token
	 */
	public String createToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	/**
	 * 
	 * @param username
	 * @return generated token
	 */
	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<String, Object>();
		return createToken(claims, username);
	}

	/**
	 * 
	 * @param token
	 * @return getting data
	 */
	public String getUsernameFromToken(String token) {
		Claims claim = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
		return claim.getSubject();
	}

	/**
	 * 
	 * @param token
	 * @return validating token
	 */
	public boolean isValidToken(String token) {
		String username = getUsernameFromToken(token);
		if (username == null || username.equals(""))
			return false;
		return true;
	}
}
