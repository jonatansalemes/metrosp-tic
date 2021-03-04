package com.jslsolucoes.metrosp.tic.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "software_version_sq", allocationSize = 1, initialValue = 1, sequenceName = "software_version_sq")
public class SoftwareVersion {

	@Id
	@GeneratedValue(generator = "software_version_sq", strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "id_software", nullable = false)
	private Software software;

	public SoftwareVersion() {

	}

	public SoftwareVersion(Software software, String name) {
		this.software = software;
		this.name = name;
	}

	public Long id() {
		return id;
	}

	public String name() {
		return name;
	}

	public Software software() {
		return software;
	}

	public String softwareName() {
		return software.name();
	}

}
