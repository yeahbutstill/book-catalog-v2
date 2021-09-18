package com.subrutin.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.catalog.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
