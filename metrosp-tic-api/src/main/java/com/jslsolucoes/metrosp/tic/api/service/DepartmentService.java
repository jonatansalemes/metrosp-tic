package com.jslsolucoes.metrosp.tic.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslsolucoes.metrosp.tic.api.domain.Department;
import com.jslsolucoes.metrosp.tic.api.repo.DepartmentRepo;

@Service
public class DepartmentService {

	private final DepartmentRepo departmentRepo;

	@Autowired
	public DepartmentService(DepartmentRepo departmentRepo) {
		this.departmentRepo = departmentRepo;
	}
	
	public List<Department> search(String term) {
		return departmentRepo.search(term);
	}
}
