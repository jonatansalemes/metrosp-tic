package com.jslsolucoes.metrosp.tic.api.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "ticket_sq", allocationSize = 1, initialValue = 1, sequenceName = "ticket_sq")
public class Ticket {

	@Id
	@GeneratedValue(generator = "ticket_sq", strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String fullName;

	@Column(nullable = false)
	private String phone;

	@Column(nullable = false)
	private String email;

	@ManyToOne
	@JoinColumn(name = "id_software_version", nullable = false)
	private SoftwareVersion softwareVersion;

	@Column(nullable = false)
	private String hostname;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private String ip;

	public Ticket() {

	}

	public Ticket(String fullName, String phone, String email, SoftwareVersion softwareVersion, String hostname,
			String ip,LocalDateTime createdAt) {
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.softwareVersion = softwareVersion;
		this.hostname = hostname;
		this.ip = ip;
		this.createdAt = createdAt;
	}

	public Long id() {
		return id;
	}
	
	public LocalDateTime createdAt() {
		return createdAt;
	}

	public String fullName() {
		return fullName;
	}

	public String phone() {
		return phone;
	}

	public SoftwareVersion softwareVersion() {
		return softwareVersion;
	}

	public String email() {
		return email;
	}

	public String hostname() {
		return hostname;
	}

	public String ip() {
		return ip;
	}

	public String softwareVersionName() {
		return softwareVersion.softwareName() + " " + softwareVersion.name();
	}

}
