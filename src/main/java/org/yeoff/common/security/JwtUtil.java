package org.yeoff.common.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUtil {

  private final SecretKey secretKey;

  public String generateToken(Long boardId) {
    return Jwts.builder().subject("")
      .signWith(secretKey)
      .expiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
      .claim("boardId", boardId)
      .compact();
  }

  public Integer certifyToken(String token) {
    try {
      Jwt<?, ?> jwt = Jwts.parser().verifyWith(secretKey).build().parse(token);
      Claims claims = (Claims) jwt.getPayload();

      return (int) claims.get("boardId");
    } catch (Exception e) {
      return null;
    }
  }
}
