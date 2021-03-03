package com.jslsolucoes.metrosp.tic.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jslsolucoes.metrosp.tic.api.domain.Software;

@Repository
public interface SoftwareRepo extends CrudRepository<Software, Long> {

	@Query("select s from Software s order by s.name")
	public List<Software> all();
}
