package com.subrutin.catalog.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "address")
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8063189207306394490L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
	private Author author;
	
	@Column(name = "street_name", nullable = false)
	private String streetName;
	
	@Column(name = "district_name",nullable = false)
	private String disctrictName;
	
	@Column(name = "city_name",nullable = false)
	private String cityName;
	
	@Column(name = "zip_code",nullable = false)
	private String zipCode;
	
	

}
