package com.wiji.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wiji.lookify.models.Song;



public interface SongRepository extends CrudRepository<Song, Long> {

	List<Song> findAll();
	
	List<Song> findTop10ByOrderByRatingDesc();
	
	List<Song> findSongsByArtist(String keyword);

//	List<Expense> findByVendorContaining(String search);
//
//   Long countByExpenseContaining(String search);
//
//   Long deleteByExpenseStartingWith(String search);
}
