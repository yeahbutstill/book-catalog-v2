package com.subrutin.catalog.security.model;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class AnonymousAuthentication extends AbstractAuthenticationToken {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -19773817651656000L;

	public AnonymousAuthentication() {
		super(null);
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return null;
	}

	@Override
	public boolean isAuthenticated() {
		return true;
	}

	
	
}
