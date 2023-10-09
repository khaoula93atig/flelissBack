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

	      
	  public String generateTokenBylogin (String login){
	      
			return Jwts.builder()
					.setSubject(login)
					.setExpiration(new Date(System.currentTimeMillis() +1000*60*15 ))
					.signWith(SignatureAlgorithm.HS512, jwtSecret )
					.compact();
		   
	 }

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
	  
	//retrieve username from jwt token
	  public String getUsernameFromToken(String authToken) {
	      return getClaimFromToken(authToken, Claims::getSubject);
	  }
	  
	  public <T> T getClaimFromToken(String authToken, Function<Claims, T> claimsResolver) {
	      final Claims claims = getAllClaimsFromToken(authToken);
	      return claimsResolver.apply(claims);
	  }
	//for retrieveing any information from token we will need the secret key
	  private Claims getAllClaimsFromToken(String authToken) {
	      return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken).getBody();
	  }
	  
	//retrieve expiration date from jwt token
	    public Date getExpirationDateFromToken(String authToken) {
	        return getClaimFromToken(authToken, Claims::getExpiration);
	    }
	    
	  //check if the token has expired
	    public Boolean isTokenExpired(String authToken) {
	        final Date expiration = getExpirationDateFromToken(authToken);
	        return expiration.before(new Date());
	    }
		  
}
