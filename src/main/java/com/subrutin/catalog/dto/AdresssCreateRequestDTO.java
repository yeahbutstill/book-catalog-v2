package com.subrutin.catalog.dto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AdresssCreateRequestDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2371545110036859238L;

	private String streetName;
	
	private String districtName;
	
	private String cityName;

	private String zipCode;


}
