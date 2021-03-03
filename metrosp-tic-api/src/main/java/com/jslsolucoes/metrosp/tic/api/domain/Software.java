package com.jslsolucoes.metrosp.tic.api.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "software_sq", allocationSize = 1, initialValue = 1, sequenceName = "software_sq")
public class Software {

	@Id
	@GeneratedValue(generator = "software_sq", strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "software", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<SoftwareVersion> versions = new HashSet<>();

	public Software() {

	}

	public Software(String name) {
		this.name = name;
	}

	public Long id() {
		return id;
	}

	public String name() {
		return name;
	}

	public Set<SoftwareVersion> versions() {
		return versions;
	}

	public Software setVersions(Set<SoftwareVersion> versions) {
		this.versions.retainAll(versions);
		this.versions.addAll(versions);
		return this;
	}
}
