package com.wiji.languages.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.wiji.languages.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {

			List<Language> findAll();

//			List<Expense> findByVendorContaining(String search);
	//
//		   Long countByExpenseContaining(String search);
	//
//		   Long deleteByExpenseStartingWith(String search);
	}
