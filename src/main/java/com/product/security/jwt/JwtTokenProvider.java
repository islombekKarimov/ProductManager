package com.product.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@Log
public class JwtTokenProvider {

  private final String SECRET_KEY = "securesecuresecuresecuresecure";

  public String generateToken(String login) {
    Claims claims = Jwts.claims().setSubject(login);
    Date date =
        Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
    return Jwts.builder()
        .setSubject(login)
        .setClaims(claims)
        .setExpiration(date)
        .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
        .compact();
  }

  public boolean validateToken(String token) {
    try {
      Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
      return !claims.getBody().getExpiration().before(new Date());
    } catch (Exception e) {
      log.severe("invalid token");
      return false;
    }
  }

  public String getLogin(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
  }


}
