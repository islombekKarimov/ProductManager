package com.product.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@Log
public class JwtTokenProvider {
    private final String SECRET_KEY = "securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecure";


  public String generateToken(String login) {
    Claims claims = Jwts.claims().setSubject(login);
    Date date =
        Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
    return Jwts.builder()
        .setSubject(login)
        .setClaims(claims)
        .setExpiration(date)
        .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
        .compact();
  }

  public boolean validateToken(String token) {
      try {
          Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
          return true;
      } catch (Exception e) {
          log.severe("invalid token");
      }
      return false;
  }

  public String getLogin(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
  }


}
