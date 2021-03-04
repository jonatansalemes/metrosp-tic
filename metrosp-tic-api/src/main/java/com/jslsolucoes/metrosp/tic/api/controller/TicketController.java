package com.jslsolucoes.metrosp.tic.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jslsolucoes.metrosp.tic.api.domain.Ticket;
import com.jslsolucoes.metrosp.tic.api.service.TicketService;

@RestController
@RequestMapping("api/v1/tickets")
public class TicketController {

	private final TicketService ticketService;

	@Autowired
	public TicketController(final TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@GetMapping
	public List<TicketView> all() {
		return ticketService.all().stream().map(TicketView::new).collect(Collectors.toList());
	}

	@PostMapping
	@Transactional(timeout = 30000)
	public ResponseEntity<TicketView> createNewAppointment(
			@RequestBody @Valid TicketCreateRequest ticketCreateRequest) {
		Ticket ticket = ticketService.createNewOne(ticketCreateRequest.fullName(), ticketCreateRequest.phone(),
				ticketCreateRequest.email(), ticketCreateRequest.idSoftwareVersion(), ticketCreateRequest.hostname(),
				ticketCreateRequest.ip());
		return Responses.created(new TicketView(ticket), "/{id}", ticket.id());
	}

	static class TicketCreateRequest {

		@NotNull
		private final String fullName;

		@NotNull
		private final String ip;

		@NotNull
		private final Long idSoftwareVersion;

		@NotNull
		private final String hostname;

		@NotNull
		private final String email;

		@NotNull
		private final String phone;

		@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
		public TicketCreateRequest(@JsonProperty("fullName") final String fullName, @JsonProperty("ip") final String ip,
				@JsonProperty("hostname") final String hostname, @JsonProperty("email") final String email,
				@JsonProperty("phone") final String phone,
				@JsonProperty("idSoftwareVersion") final Long idSoftwareVersion) {
			this.fullName = fullName;
			this.ip = ip;
			this.hostname = hostname;
			this.email = email;
			this.phone = phone;
			this.idSoftwareVersion = idSoftwareVersion;
		}

		public String fullName() {
			return fullName;
		}

		public Long idSoftwareVersion() {
			return idSoftwareVersion;
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

}
