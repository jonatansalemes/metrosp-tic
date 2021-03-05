package com.jslsolucoes.metrosp.tic.api.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "mobile_order_sq", allocationSize = 1, initialValue = 1, sequenceName = "mobile_order_sq")
public class MobileOrder {

	@Id
	@GeneratedValue(generator = "mobile_order_sq", strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String reason;

	@ManyToOne
	@JoinColumn(name = "id_department", nullable = false)
	private Department department;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	public MobileOrder() {

	}

	public MobileOrder(String reason, Department department, LocalDateTime createdAt) {
		this.reason = reason;
		this.department = department;
		this.createdAt = createdAt;
	}

	public Long id() {
		return id;
	}

	public Department department() {
		return department;
	}

	public String reason() {
		return reason;
	}

	public LocalDateTime createdAt() {
		return createdAt;
	}

	public String departamentName() {
		return department.name();
	}

}
