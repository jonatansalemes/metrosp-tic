package com.jslsolucoes.metrosp.tic.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jslsolucoes.metrosp.tic.api.domain.MobileOrder;

@Repository
public interface MobileOrderRepo extends CrudRepository<MobileOrder, Long> {

	@Query("select mo from MobileOrder mo order by mo.createdAt desc")
	public List<MobileOrder> all();

}
