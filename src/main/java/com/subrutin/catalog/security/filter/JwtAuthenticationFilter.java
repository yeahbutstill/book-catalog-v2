package com.subrutin.catalog.security.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.subrutin.catalog.security.model.JwtAuthenticationToken;
import com.subrutin.catalog.security.model.RawAccessJWTToken;
import com.subrutin.catalog.security.util.TokenExtractor;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter{
	
	private final TokenExtractor tokenExtractor;

	public JwtAuthenticationFilter(TokenExtractor tokenExtractor, RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
		this.tokenExtractor =tokenExtractor;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		String tokenPayload =  request.getHeader("Authorization"); //bearer xxx.yyy.zzz
		RawAccessJWTToken token = new RawAccessJWTToken(tokenExtractor.extract(tokenPayload));
		return this.getAuthenticationManager().authenticate(new JwtAuthenticationToken(token));
	}

}
