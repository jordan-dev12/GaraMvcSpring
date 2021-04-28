package com.security;

import java.util.Date;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	public static String generateToken(String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, CostantiSecurity.secret);
        return builder.compact();
    }
	
	public static String getSubject(String jwtToken){
       
        return Jwts.parser().setSigningKey(CostantiSecurity.secret).parseClaimsJws(jwtToken).getBody().getSubject();
    }
	
	
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(CostantiSecurity.secret).parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
		
		}

		return false;
	}

}
