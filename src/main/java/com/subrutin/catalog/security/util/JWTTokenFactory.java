package com.subrutin.catalog.security.util;

import com.subrutin.catalog.security.model.AccessJWTToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JWTTokenFactory {

    private final Key key;

    public AccessJWTToken createAccessJWTToken(String username, Collection<? extends GrantedAuthority> authorities) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("scopes", authorities.stream().map(a -> a.getAuthority()).collect(Collectors.toList()));
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime expiredTime = currentTime.plusMinutes(15);

        Date currentTimeDate = Date.from(currentTime.atZone(ZoneId.of("Asia/Jakarta")).toInstant());
        Date expiredTimeDate = Date.from(expiredTime.atZone(ZoneId.of("Asia/Jakarta")).toInstant());

        String token = Jwts.builder().setClaims(claims)
                .setIssuer("http://subrutin.com").setIssuedAt(currentTimeDate)
                .setExpiration(expiredTimeDate)
                .signWith(key, SignatureAlgorithm.HS256).compact();

        return new AccessJWTToken(token, claims);

    }

}
