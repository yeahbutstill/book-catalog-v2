package com.subrutin.catalog.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class BookListResponseDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5170673294636439970L;

	private String id;
	
	private String title;
	
	private String description;

	private String publisherName;
	
	private List<String> authorNames;
	
	private List<String> categoryCodes;
}
