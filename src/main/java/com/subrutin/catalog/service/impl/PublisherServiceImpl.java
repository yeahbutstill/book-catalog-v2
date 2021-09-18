package com.subrutin.catalog.service.impl;

import org.springframework.stereotype.Service;

import com.subrutin.catalog.domain.Publisher;
import com.subrutin.catalog.dto.PublisherCreateDTO;
import com.subrutin.catalog.repository.PublisherRepository;
import com.subrutin.catalog.service.PublisherService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PublisherServiceImpl implements PublisherService{

	
	private final PublisherRepository publisherRepository;
	
	
	@Override
	public void createPublisher(PublisherCreateDTO dto) {
		Publisher publisher = new Publisher();
		publisher.setName(dto.getName());
		publisher.setCompanyName(dto.getCompanyName());
		publisherRepository.save(publisher);
		
	}

}
