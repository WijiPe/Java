package com.wiji.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wiji.lookify.models.Song;
import com.wiji.lookify.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	private SongService songService;
	
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@GetMapping("/songs/new")
	public String form(@ModelAttribute("song") Song song) {
		return "createForm.jsp";
	}
	
	@GetMapping("/songs")
	public String dashboard(@ModelAttribute("song")Song song, Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@PostMapping("/submitForm")
	public String post(@Valid @ModelAttribute("song")Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "createForm.jsp";
		}else {
			songService.createSong(song);
			return "redirect:/songs";
		}
	}
	
	@GetMapping("/songs/{id}")
	public String showOneSong(@PathVariable("id")Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "details.jsp";
	}
	
	@GetMapping("/songs/edit/{id}")
	public String editForm(@PathVariable("id")Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "edit.jsp";
	}
	
	@PutMapping("/songs/edit/{id}")
	public String edit(@Valid @ModelAttribute("song")Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			songService.updateSong(song);
			return "redirect:/songs";
		}
	}
	
	@DeleteMapping("/songs/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		songService.deleteSong(id);
		return "redirect:/songs";
	}
	
	@GetMapping("/songs/topten")
	public String topten(Model model) {
		List<Song> songs = songService.toptenSong();
		model.addAttribute("songs", songs);
		return "topten.jsp";
	}
	@PostMapping("/songs/search")
	public String searchQuery(@RequestParam("keyword") String keyword) {
		return "redirect:/songs/search/"+keyword;
	}
	
	@GetMapping("/songs/search/{keyword}")
	public String showSongsByArtist(@PathVariable("keyword")String keyword, Model model) {
		List<Song> songs = songService.searchArtist(keyword);
		model.addAttribute("songs", songs);
		return "search.jsp";
	}
}
