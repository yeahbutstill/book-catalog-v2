package com.subrutin.catalog.security.model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.io.Serializable;
import java.security.Key;

public class RawAccessJWTToken implements Token, Serializable {

    private static final long serialVersionUID = -2792655556685663365L;

    private final String token;

    public RawAccessJWTToken(String token) {
        super();
        this.token = token;
    }


    public Jws<Claims> parseClaims(Key signingKey) {
        return Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(this.token);
    }

    @Override
    public String getToken() {
        return this.token;
    }

}
