package com.jslsolucoes.metrosp.tic.api.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jslsolucoes.metrosp.tic.api.domain.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Long> {

	@Query("select d from Department d where lower(d.name) like %:term% order by d.name")
	public List<Department> search(@Param("term") String term);
	
	@Query("select d from Department d where d.id = :idDepartament")
	public Optional<Department> department(@Param("idDepartament") Long idDepartament);

	@Query("select d from Department d order by d.name")
	public List<Department> all();

}
