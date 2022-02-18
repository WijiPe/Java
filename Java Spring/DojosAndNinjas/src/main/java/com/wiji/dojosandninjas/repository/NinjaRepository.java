package com.wiji.dojosandninjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wiji.dojosandninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
