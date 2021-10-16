package com.subrutin.catalog.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.subrutin.catalog.domain.ApplicationUser;
import com.subrutin.catalog.repository.ApplicationUserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicationUserDetailService implements UserDetailsService {

	private final ApplicationUserRepository applicationUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser appUser =  applicationUserRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("username not found"));

		return appUser;
	}

}
