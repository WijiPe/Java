package com.wiji.studentroster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wiji.studentroster.models.Dormitory;

public interface DormitoryRepository extends CrudRepository<Dormitory, Long> {
	List<Dormitory> findAll();
}
