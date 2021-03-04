package com.jslsolucoes.metrosp.tic.api.controller;

import java.time.LocalDateTime;

import com.jslsolucoes.metrosp.tic.api.domain.Ticket;

public class TicketView {

	private final String fullName;
	private final String ip;
	private final String software;
	private final String hostname;
	private final String email;
	private final String phone;
	private final LocalDateTime createdAt;

	public TicketView(Ticket ticket) {
		this.fullName = ticket.fullName();
		this.ip = ticket.fullName();
		this.software = ticket.softwareVersionName();
		this.hostname = ticket.hostname();
		this.email = ticket.email();
		this.phone = ticket.phone();
		this.createdAt = ticket.createdAt();
	}

	public LocalDateTime createdAt() {
		return createdAt;
	}

	public String fullName() {
		return fullName;
	}

	public String software() {
		return software;
	}

	public String ip() {
		return ip;
	}

	public String hostname() {
		return hostname;
	}

	public String email() {
		return email;
	}

	public String phone() {
		return phone;
	}
}
