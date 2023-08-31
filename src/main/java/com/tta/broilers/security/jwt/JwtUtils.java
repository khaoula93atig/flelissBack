package com.tta.broilers.security.jwt;

import java.util.Date;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import com.tta.broilers.security.services.UsersDetailsImpl;

import io.jsonwebtoken.*;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	  @Value("${jwt.secret}")
	  private String jwtSecret;

	  @Value("${jwt.jwtExpirationMs}")
	  private int jwtExpirationMs;

	  
	  public String generateJwtToken(Authentication authentication) {

		    UsersDetailsImpl userPrincipal = (UsersDetailsImpl) authentication.getPrincipal();

		    return Jwts.builder()
		        .setSubject((userPrincipal.getUsername()))
		        .setIssuedAt(new Date())
		        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
		        .signWith(SignatureAlgorithm.HS512, jwtSecret)
		        .compact();
		  }

	      
	     /* private Key key() {
	        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	      }

	      public String getUserNameFromJwtToken(String token) {
	        return Jwts.parserBuilder().setSigningKey(key()).build()
	                   .parseClaimsJws(token).getBody().getSubject();
	      }*/

	  public boolean validateJwtToken(String authToken) {
		    try {
		      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
		      return true;
		    } catch (SignatureException e) {
		      logger.error("Invalid JWT signature: {}", e.getMessage());
		    } catch (MalformedJwtException e) {
		      logger.error("Invalid JWT token: {}", e.getMessage());
		    } catch (ExpiredJwtException e) {
		      logger.error("JWT token is expired: {}", e.getMessage());
		    } catch (UnsupportedJwtException e) {
		      logger.error("JWT token is unsupported: {}", e.getMessage());
		    } catch (IllegalArgumentException e) {
		      logger.error("JWT claims string is empty: {}", e.getMessage());
		    }

		    return false;
		  }
	  
	  public String getUserNameFromJwtToken(String authToken) {
		    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken).getBody().getSubject();
		  }
		  
}