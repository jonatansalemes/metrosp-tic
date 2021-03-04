package com.jslsolucoes.metrosp.tic.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jslsolucoes.metrosp.tic.api.domain.Ticket;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Long> {

	@Query("select t from Ticket t order by t.createdAt desc")
	public List<Ticket> all();

}
