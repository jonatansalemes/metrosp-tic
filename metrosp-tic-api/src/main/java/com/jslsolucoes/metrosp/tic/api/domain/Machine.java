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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "machine_sq", allocationSize = 1, initialValue = 1, sequenceName = "machine_sq")
public class Machine {

	@Id
	@GeneratedValue(generator = "machine_sq", strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String uuid;

	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;

	@Column(nullable = false)
	private String hostname;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "machine", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<MachineInterface> interfaces = new HashSet<>();

	public Machine() {

	}

	public Machine(String uuid, String hostname, User user) {
		this.uuid = uuid;
		this.hostname = hostname;
		this.user = user;
	}

	public Machine setInterfaces(Set<MachineInterface> interfaces) {
		this.interfaces.retainAll(interfaces);
		this.interfaces.addAll(interfaces);
		return this;
	}

	public Long id() {
		return id;
	}

	public String uuid() {
		return uuid;
	}

	public String hostname() {
		return hostname;
	}

	public Set<MachineInterface> interfaces() {
		return interfaces;
	}

	public String userEmail() {
		return user.email();
	}

	public String userPhone() {
		return user.phone();
	}

	public String userFullName() {
		return user.fullName();
	}

}
