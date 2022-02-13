package com.subrutin.catalog.security.model;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {
	
	

	/**
	 * 
	 */
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

	
}
