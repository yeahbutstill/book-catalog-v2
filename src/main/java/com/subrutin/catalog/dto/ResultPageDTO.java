package com.subrutin.catalog.dto;

import java.util.Collection;

import lombok.Data;

@Data
public class ResultPageDTO<T> {

	private Collection<T> result;
	
	private Integer pages;
	
	private Long elements;
}
