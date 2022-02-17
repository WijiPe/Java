package com.wiji.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.wiji.lookify.models.Song;
import com.wiji.lookify.repository.SongRepository;

@Service
public class SongService {
	
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		 this.songRepository = songRepository;
	}
	
	 public List<Song> allSongs() {
		 return  songRepository.findAll();
	 }
	 
	 public Song createSong(Song song) {
	     return songRepository.save(song);
	 }
	 
	 public Song findSong(Long id) {
	     Optional<Song> optionalSong = songRepository.findById(id);
	     if(optionalSong.isPresent()) {
	         return optionalSong.get();
	     } else {
	         return null;
	     }
	 }
	 
	 public Song updateSong(Song song) {
		 	return songRepository.save(song);
	}
	 
	 public void deleteSong(Long id) {
		 songRepository.deleteById(id);
	}
	 
	 public List<Song> toptenSong() {
		 return songRepository.findTop10ByOrderByRatingDesc();
	}
	 
	 public List<Song> searchArtist(String keyword) {
		 return songRepository.findSongsByArtist(keyword);
	}
}
