package com.subrutin.catalog.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;


@Data
@Entity
@Table(name = "role")
public class Role implements Serializable, GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5267272545778114960L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;

	@Override
	public String getAuthority() {
		return "ROLE_"+name;
	}
}
