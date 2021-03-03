package com.jslsolucoes.metrosp.tic.api.controller;

import com.jslsolucoes.metrosp.tic.api.domain.SoftwareVersion;

public class SoftwareView {

	private final Long id;
	private final String name;
	private final String version;

	public SoftwareView(final SoftwareVersion softwareVersion) {
		this.id = softwareVersion.id();
		this.name = softwareVersion.softwareName();
		this.version = softwareVersion.name();
	}

	public Long id() {
		return id;
	}

	public String name() {
		return name;
	}

	public String version() {
		return version;
	}

}
