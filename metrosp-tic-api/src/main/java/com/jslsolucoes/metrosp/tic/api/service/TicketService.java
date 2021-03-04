package com.jslsolucoes.metrosp.tic.api.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslsolucoes.metrosp.tic.api.domain.SoftwareVersion;
import com.jslsolucoes.metrosp.tic.api.domain.Ticket;
import com.jslsolucoes.metrosp.tic.api.repo.SoftwareRepo;
import com.jslsolucoes.metrosp.tic.api.repo.TicketRepo;

@Service
public class TicketService {

	private final TicketRepo ticketRepo;
	private final SoftwareRepo softwareRepo;

	@Autowired
	public TicketService(TicketRepo ticketRepo, SoftwareRepo softwareRepo) {
		this.ticketRepo = ticketRepo;
		this.softwareRepo = softwareRepo;
	}

	public List<Ticket> all() {
		return ticketRepo.all();
	}

	public Ticket createNewOne(String fullName, String phone, String email, Long idSoftwareVersion, String hostname,
			String ip) {
		SoftwareVersion softwareVersion = softwareRepo.version(idSoftwareVersion).orElseThrow(
				() -> new EntityNotFoundException("Could not find software version with id " + idSoftwareVersion));
		return ticketRepo.save(new Ticket(fullName, phone, email, softwareVersion, hostname, ip, LocalDateTime.now()));
	}
}
