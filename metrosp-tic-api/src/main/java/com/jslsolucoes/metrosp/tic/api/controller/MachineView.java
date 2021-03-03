package com.jslsolucoes.metrosp.tic.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.jslsolucoes.metrosp.tic.api.domain.Machine;
import com.jslsolucoes.metrosp.tic.api.domain.MachineInterface;

public class MachineView {

	private String uuid;
	private String hostname;
	private List<String> interfaces;

	public MachineView(Machine machine) {
		this.uuid = machine.uuid();
		this.hostname = machine.hostname();
		this.interfaces = machine.interfaces().stream().map(MachineInterface::address).collect(Collectors.toList());
	}

	public String uuid() {
		return uuid;
	}

	public String hostname() {
		return hostname;
	}

	public List<String> interfaces() {
		return interfaces;
	}

}
