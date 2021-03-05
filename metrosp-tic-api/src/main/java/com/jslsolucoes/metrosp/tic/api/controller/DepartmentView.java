package com.jslsolucoes.metrosp.tic.api.controller;

import com.jslsolucoes.metrosp.tic.api.domain.Department;

public class DepartmentView {

	private final Long id;
	private final String name;

	public DepartmentView(Department department) {
		this.id = department.id();
		this.name = department.name();
	}

	public String name() {
		return name;
	}

	public Long id() {
		return id;
	}
}
