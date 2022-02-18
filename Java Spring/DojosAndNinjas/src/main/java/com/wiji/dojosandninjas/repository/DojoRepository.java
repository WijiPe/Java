package com.wiji.dojosandninjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wiji.dojosandninjas.models.Dojo;
import com.wiji.dojosandninjas.models.Ninja;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
