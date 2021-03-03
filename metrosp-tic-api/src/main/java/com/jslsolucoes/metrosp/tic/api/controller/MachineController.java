package com.jslsolucoes.metrosp.tic.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jslsolucoes.metrosp.tic.api.service.MachineService;

@RestController
@RequestMapping("api/v1/machines")
public class MachineController {

	private final MachineService machineService;

	@Autowired
	public MachineController(final MachineService machineService) {
		this.machineService = machineService;
	}

	@GetMapping("{uuid}")
	public MachineView all(@PathVariable("uuid") String uuid) {
		return new MachineView(machineService.findByUuid(uuid));
	}
}
