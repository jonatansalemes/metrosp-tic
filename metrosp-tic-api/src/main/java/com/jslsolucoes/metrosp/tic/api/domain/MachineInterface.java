package com.jslsolucoes.metrosp.tic.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "machine_interface_sq", allocationSize = 1, initialValue = 1, sequenceName = "machine_interface_sq")
public class MachineInterface {

	@Id
	@GeneratedValue(generator = "machine_interface_sq", strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_machine", nullable = false)
	private Machine machine;
	
	public MachineInterface() {
	
	}

	public MachineInterface(Machine machine, String address) {
		this.address = address;
		this.machine = machine;
	}

	public Long id() {
		return id;
	}

	public Machine machine() {
		return machine;
	}

	public String address() {
		return address;
	}

}
