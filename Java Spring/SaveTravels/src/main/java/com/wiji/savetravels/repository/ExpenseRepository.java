package com.wiji.savetravels.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.wiji.savetravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
		
		List<Expense> findAll();

		List<Expense> findByVendorContaining(String search);

	   Long countByExpenseContaining(String search);

	   Long deleteByExpenseStartingWith(String search);
}
