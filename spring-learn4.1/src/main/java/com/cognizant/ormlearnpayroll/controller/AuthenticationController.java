package com.cognizant.ormlearnpayroll.controller;

import java.util.Date;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationController {

	@SuppressWarnings("unused")
	private String generateJwt(String user) 
	{
		JwtBuilder builder = Jwts.builder(); 
		builder.setSubject(user); 
		builder.setIssuedAt(new Date()); 
		builder.setExpiration(new Date((new Date()).getTime() + 1200000)); 
		builder.signWith(SignatureAlgorithm.HS256, "secretkey"); 
		String token = builder.compact(); 
		return token;

		
	}
}
