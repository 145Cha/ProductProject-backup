package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.PlaylistService;
import com.kodnest.tunehub.service.SongService;

@Controller
public class PlaylistController {
	
	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	SongService songService;
	
	@GetMapping("/createplaylists")
	public String createPlaylist(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylists";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		playlistService.addPlaylist(playlist);
		
		//updating the song_playlists table
		List<Song> songs = playlist.getSongs();
		
		for (Song song : songs) {
			song.getPlaylists().add(playlist);
			songService.updateSong(song);
		}
		
		return "adminhome";
	}
	
	
	@GetMapping("/viewplaylist")
	public String viewplaylist(Model model) {
	List<Playlist>playlist = playlistService.getAllPlaylists();
	model.addAttribute("playlists" ,playlist);
	return "viewplaylists";
	}
	
}

