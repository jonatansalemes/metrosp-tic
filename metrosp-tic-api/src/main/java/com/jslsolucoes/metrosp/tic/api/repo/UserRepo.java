package com.jslsolucoes.metrosp.tic.api.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jslsolucoes.metrosp.tic.api.domain.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

}