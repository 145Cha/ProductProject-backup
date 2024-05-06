package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.repository.PlaylistRepository;
import com.kodnest.tunehub.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addPlaylist(Playlist playlist) {
		 Playlist existingPlaylist = playlistRepository.findByName(playlist.getName());
		if(existingPlaylist==null) {
			playlistRepository.save(playlist);	
		}else {
			System.out.println("Playlist Already Existed");
		}
			
	}

	@Override
	public List<Playlist> getAllPlaylists() {
		
		List<Playlist> songs =  playlistRepository.findAll();
		return songs;
	}

}
