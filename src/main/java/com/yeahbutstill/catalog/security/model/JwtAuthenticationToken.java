package com.yeahbutstill.catalog.security.model;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 6317753011953515893L;

    private RawAccessJWTToken rawAccessJWTToken;

    private UserDetails userDetails;

    public JwtAuthenticationToken(RawAccessJWTToken rawAccessJWTToken) {
        super(null);
        this.rawAccessJWTToken = rawAccessJWTToken;
        this.setAuthenticated(false);
    }


    public JwtAuthenticationToken(UserDetails userDetails, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.eraseCredentials();
        this.userDetails = userDetails;
        super.setAuthenticated(true);
    }


    @Override
    public Object getCredentials() {
        return this.rawAccessJWTToken;
    }

    @Override
    public Object getPrincipal() {
        return this.userDetails;
    }


    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        this.rawAccessJWTToken = null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JwtAuthenticationToken that = (JwtAuthenticationToken) o;
        return Objects.equals(rawAccessJWTToken, that.rawAccessJWTToken) && Objects.equals(userDetails, that.userDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rawAccessJWTToken, userDetails);
    }

    @Override
    public String toString() {
        return "JwtAuthenticationToken{" +
                "rawAccessJWTToken=" + rawAccessJWTToken +
                ", userDetails=" + userDetails +
                '}';
    }

}
