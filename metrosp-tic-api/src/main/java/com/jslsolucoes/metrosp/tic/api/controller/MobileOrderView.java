package com.jslsolucoes.metrosp.tic.api.controller;

import java.time.LocalDateTime;

import com.jslsolucoes.metrosp.tic.api.domain.MobileOrder;

public class MobileOrderView {

	private Long id;
	private String reason;
	private LocalDateTime createdAt;
	private String department;

	public MobileOrderView(MobileOrder mobileOrder) {
		this.id = mobileOrder.id();
		this.reason = mobileOrder.reason();
		this.createdAt = mobileOrder.createdAt();
		this.department = mobileOrder.departamentName();
	}

	public Long id() {
		return id;
	}

	public String reason() {
		return reason;
	}

	public LocalDateTime createdAt() {
		return createdAt;
	}

	public String department() {
		return department;
	}
}
