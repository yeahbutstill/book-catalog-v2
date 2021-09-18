package com.subrutin.catalog.web;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.subrutin.catalog.dto.PublisherCreateDTO;
import com.subrutin.catalog.service.PublisherService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class PublisherResource {

	private final PublisherService publisherService;
	
	@PostMapping("/publisher")
	public ResponseEntity<Void> createPublisher(@RequestBody PublisherCreateDTO dto){
		publisherService.createPublisher(dto);
		return ResponseEntity.created(URI.create("/")).build();
	}
}
