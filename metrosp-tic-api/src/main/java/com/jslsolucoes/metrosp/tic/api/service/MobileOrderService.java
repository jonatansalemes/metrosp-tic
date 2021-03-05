package com.jslsolucoes.metrosp.tic.api.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslsolucoes.metrosp.tic.api.domain.Department;
import com.jslsolucoes.metrosp.tic.api.domain.MobileOrder;
import com.jslsolucoes.metrosp.tic.api.repo.DepartmentRepo;
import com.jslsolucoes.metrosp.tic.api.repo.MobileOrderRepo;

@Service
public class MobileOrderService {

	private final MobileOrderRepo mobileOrderRepo;
	private final DepartmentRepo departmentRepo;

	@Autowired
	public MobileOrderService(MobileOrderRepo mobileOrderRepo, DepartmentRepo departmentRepo) {
		this.mobileOrderRepo = mobileOrderRepo;
		this.departmentRepo = departmentRepo;
	}

	public List<MobileOrder> all() {
		return mobileOrderRepo.all();
	}

	public MobileOrder createNewOne(String reason, Long idDepartment) {
		Department department = departmentRepo.department(idDepartment)
				.orElseThrow(() -> new EntityNotFoundException("Could not find department with id " + idDepartment));
		return mobileOrderRepo.save(new MobileOrder(reason, department, LocalDateTime.now()));
	}
}
