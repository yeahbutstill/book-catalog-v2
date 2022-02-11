package com.subrutin.catalog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.subrutin.catalog.security.filter.UsernamePasswordAuthenticationFilter;
import com.subrutin.catalog.security.provider.UsernamePasswordAuthProvider;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static final String V1_URL = "/v1/**";
	private static final String V2_URL = "/v2/**";
	
	@Autowired
	private AuthenticationFailureHandler failureHandler;

	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Autowired
	private UsernamePasswordAuthProvider usernamePasswordAuthProvider;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Autowired
	private ObjectMapper objectMapper;
	
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(appUserService).passwordEncoder(passwordEncoder());
		auth.authenticationProvider(usernamePasswordAuthProvider);
	}
	
	
	protected UsernamePasswordAuthenticationFilter buildUsernamePasswordAuthFilter(String loginEntryPoint) {
		UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter(loginEntryPoint, successHandler, failureHandler, objectMapper);
		filter.setAuthenticationManager(authenticationManager);
		return filter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(V1_URL, V2_URL).authenticated()
		.and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(buildUsernamePasswordAuthFilter("/v1/login"), org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);
	}

	

	
	
}
