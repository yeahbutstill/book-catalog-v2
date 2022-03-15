package com.subrutin.catalog.service;

import com.subrutin.catalog.domain.dao.Publisher;
import com.subrutin.catalog.domain.dto.*;

public interface PublisherService {

    void createPublisher(PublisherCreateRequestDTO dto);

    Publisher findPublisher(String publisherId);

    void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);

    ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages, Integer limit,
                                                                      String sortBy, String direction, String publisherName);

    PublisherResponseDTO constructDTO(Publisher publisher);

}
