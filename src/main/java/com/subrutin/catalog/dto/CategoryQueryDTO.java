package com.subrutin.catalog.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryQueryDTO implements Serializable {
	
	private Long bookId;
	
	private String categoryCode;

}
