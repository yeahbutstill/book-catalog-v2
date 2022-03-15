package com.subrutin.catalog.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookQueryDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6659767836628899525L;

	private Long id;
	
	private String bookId;
	
	private String bookTitle;
	
	private String publisherName;
	
	private String description;

}
