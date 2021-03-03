package com.jslsolucoes.metrosp.tic.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.jslsolucoes.metrosp.tic.api.domain.Machine;
import com.jslsolucoes.metrosp.tic.api.domain.MachineInterface;

public class MachineView {

	private final String uuid;
	private final String hostname;
	private final List<String> interfaces;
	private final String email;
	private final String phone;
	private final String fullName;

	public MachineView(Machine machine) {
		this.uuid = machine.uuid();
		this.hostname = machine.hostname();
		this.interfaces = machine.interfaces().stream().map(MachineInterface::address).collect(Collectors.toList());
		this.email = machine.userEmail();
		this.phone = machine.userPhone();
		this.fullName = machine.userFullName();
	}

	public String fullName() {
		return fullName;
	}

	public String email() {
		return email;
	}

	public String phone() {
		return phone;
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
