package com.jslsolucoes.metrosp.tic.api.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.util.Strings;
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

	public List<Department> all(String term) {
		if (Strings.isNotEmpty(term)) {
			return Optional.of(departmentRepo.search(term)).filter(Predicate.not(List::isEmpty))
					.orElseThrow(() -> new EntityNotFoundException("Could not find any department with term " + term));
		}
		return Optional.of(departmentRepo.all()).filter(Predicate.not(List::isEmpty))
				.orElseThrow(() -> new EntityNotFoundException("Could not find any department"));
	}
}
