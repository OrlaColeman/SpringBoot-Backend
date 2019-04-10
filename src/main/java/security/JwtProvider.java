package com.project.rest.webservice.Project.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import java.util.Date;

@Component
public class JwtProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
	

	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	final Date today = new Date();
	
	public String generateJwtToken(Authentication authentication) {
		
		UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
		
		final JwtBuilder jwtBuilder = Jwts.builder();
		jwtBuilder.setSubject((userPrinciple.getUsername()));
		jwtBuilder.setIssuedAt(new Date());
		jwtBuilder.setExpiration(today);
		return jwtBuilder.signWith(key).compact();
	}

	
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser()
					.setSigningKey(key)
					.parseClaimsJws(token)
					.getBody().getSubject();
	}
	
	public boolean validateJwtToken(String authToken) {
		try 
		{
			Jwts.parser().setSigningKey(key).parseClaimsJws(authToken);
			return true;
		}
		catch(MalformedJwtException e) {
			logger.error("Invalid JWT token -> Message: {}", e);
		}
		catch(ExpiredJwtException e){
			logger.error("Expired JWT token -> Message: {}", e);
		}
		catch(UnsupportedJwtException e) {
			logger.error("Unsupported JWT token -> Message: {}", e);
		}
		catch(IllegalArgumentException e) {
			logger.error("JWT claims string is empty -> Message: {}", e);
		}
		
		return false;
	}
}
