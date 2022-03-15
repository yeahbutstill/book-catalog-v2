package com.yeahbutstill.catalog.service.impl;

import com.yeahbutstill.catalog.repository.AppUserRepository;
import com.yeahbutstill.catalog.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("invalid username"));
    }

}
