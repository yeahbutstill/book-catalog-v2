package com.yeahbutstill.catalog.repository;

import com.yeahbutstill.catalog.domain.dao.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    public Optional<AppUser> findByUsername(String username);

}
