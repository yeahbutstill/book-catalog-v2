package com.subrutin.catalog.service;

import com.subrutin.catalog.domain.dao.Publisher;
import com.subrutin.catalog.domain.dto.PublisherCreateRequestDTO;
import com.subrutin.catalog.domain.dto.PublisherListResponseDTO;
import com.subrutin.catalog.domain.dto.PublisherResponseDTO;
import com.subrutin.catalog.domain.dto.PublisherUpdateRequestDTO;
import com.subrutin.catalog.domain.dto.ResultPageResponseDTO;

public interface PublisherService {

	public void createPublisher(PublisherCreateRequestDTO dto);
	
	public Publisher findPublisher(String publisherId);

	public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);

	public ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages, Integer limit,
			String sortBy, String direction, String publisherName);
	
	public PublisherResponseDTO constructDTO(Publisher publisher);

}
