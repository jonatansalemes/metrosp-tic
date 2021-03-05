package com.jslsolucoes.metrosp.tic.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jslsolucoes.metrosp.tic.api.service.DepartmentService;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {

	private final DepartmentService departmentService;

	@Autowired
	public DepartmentController(final DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping
	public List<DepartmentView> all(@NotNull @RequestParam("term") String term) {
		return departmentService.search(term).stream()
				.map(DepartmentView::new)
				.collect(Collectors.toList());
	}
}
