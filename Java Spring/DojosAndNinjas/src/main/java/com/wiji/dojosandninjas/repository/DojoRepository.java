package com.wiji.dojosandninjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wiji.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
