package com.jslsolucoes.metrosp.tic.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "department_sq", allocationSize = 1, initialValue = 1, sequenceName = "department_sq")
public class Department {

	@Id
	@GeneratedValue(generator = "department_sq", strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	public Department() {

	}

	public Department(String name) {
		this.name = name;
	}

	public Long id() {
		return id;
	}

	public String name() {
		return name;
	}

}
