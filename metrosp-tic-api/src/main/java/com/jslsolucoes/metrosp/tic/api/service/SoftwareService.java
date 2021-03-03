package com.jslsolucoes.metrosp.tic.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslsolucoes.metrosp.tic.api.domain.Software;
import com.jslsolucoes.metrosp.tic.api.repo.SoftwareRepo;

@Service
public class SoftwareService {

	private final SoftwareRepo softwareRepo;

	@Autowired
	public SoftwareService(SoftwareRepo softwareRepo) {
		this.softwareRepo = softwareRepo;
	}

	public List<Software> all() {
		return softwareRepo.all();
	}
}
