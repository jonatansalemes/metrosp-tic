package com.jslsolucoes.metrosp.tic.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "user_sq", allocationSize = 1, initialValue = 1, sequenceName = "user_sq")
public class User {

	@Id
	@GeneratedValue(generator = "user_sq", strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String fullName;

	@Column(nullable = false)
	private String phone;

	public User() {

	}

	public User(String email, String phone, String fullName) {
		this.email = email;
		this.phone = phone;
		this.fullName = fullName;
	}

	public Long id() {
		return id;
	}

	public String email() {
		return email;
	}

	public String phone() {
		return phone;
	}
	
	public String fullName() {
		return fullName;
	}

}
