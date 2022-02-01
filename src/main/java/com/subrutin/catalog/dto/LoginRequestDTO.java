package com.subrutin.catalog.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4553862933056697530L;

	private String username;
	
	private String password;
}
