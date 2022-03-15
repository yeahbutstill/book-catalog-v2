package com.yeahbutstill.catalog.service;

import com.yeahbutstill.catalog.domain.dao.Publisher;
import com.yeahbutstill.catalog.domain.dto.*;

public interface PublisherService {

    void createPublisher(PublisherCreateRequestDTO dto);

    Publisher findPublisher(String publisherId);

    void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);

    ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages, Integer limit,
                                                                      String sortBy, String direction, String publisherName);

    PublisherResponseDTO constructDTO(Publisher publisher);

}
