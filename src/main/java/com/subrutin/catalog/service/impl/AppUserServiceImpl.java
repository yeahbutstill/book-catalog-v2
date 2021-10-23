package com.subrutin.catalog.service.impl;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.subrutin.catalog.dto.UserDetailResponseDTO;
import com.subrutin.catalog.repository.AppUserRepository;
import com.subrutin.catalog.service.AppUserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {

	private final AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return appUserRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("invalid username"));
	}

	@Override
	public UserDetailResponseDTO findUserDetail() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		UserDetails userDetail =  (UserDetails) ctx.getAuthentication().getPrincipal();
		userDetail.getAuthorities().stream().forEach((g)->{
			System.out.println(g.getAuthority());
		});
		UserDetailResponseDTO dto = new UserDetailResponseDTO();
		String username  = ctx.getAuthentication().getName();
		dto.setUsername(username);
		return dto;
	}

}
