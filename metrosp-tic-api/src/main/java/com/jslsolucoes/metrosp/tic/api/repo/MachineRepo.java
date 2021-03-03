package com.jslsolucoes.metrosp.tic.api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jslsolucoes.metrosp.tic.api.domain.Machine;

@Repository
public interface MachineRepo extends CrudRepository<Machine, Long> {

	@Query("select m from Machine m where m.uuid= :uuid")
	public Optional<Machine> findByUuid(@Param("uuid") String uuid);

}
