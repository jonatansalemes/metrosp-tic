package com.jslsolucoes.metrosp.tic.api.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslsolucoes.metrosp.tic.api.domain.Machine;
import com.jslsolucoes.metrosp.tic.api.repo.MachineRepo;

@Service
public class MachineService {

	private final MachineRepo machineRepo;

	@Autowired
	public MachineService(MachineRepo machineRepo) {
		this.machineRepo = machineRepo;
	}

	public Machine findByUuid(String uuid) {
		return machineRepo.findByUuid(uuid)
				.orElseThrow(() -> new EntityNotFoundException("Could not find machine with uuid " + uuid));
	}
}
