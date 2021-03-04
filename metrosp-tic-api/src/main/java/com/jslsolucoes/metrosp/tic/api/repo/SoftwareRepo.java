package com.jslsolucoes.metrosp.tic.api.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jslsolucoes.metrosp.tic.api.domain.Software;
import com.jslsolucoes.metrosp.tic.api.domain.SoftwareVersion;

@Repository
public interface SoftwareRepo extends CrudRepository<Software, Long> {

	@Query("select s from Software s order by s.name")
	public List<Software> all();

	@Query("select sv from SoftwareVersion sv where sv.id = :idSoftwareVersion")
	public Optional<SoftwareVersion> version(@Param("idSoftwareVersion") Long idSoftwareVersion);

}
