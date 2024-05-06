package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl implements SongService{

	@Autowired
	SongRepository songRepository;

	@Override
	public void saveSong(Song song) {
		songRepository.save(song);
	}

	@Override
	public boolean songExists(Song song) {
		
		Song  existingsong = songRepository.findByName(song.getName());
		if(existingsong!=null) {
			System.out.println("Song present");
			return true;
		}
		else {
			System.out.println("Song absent");
			return false;
		}
		
	
		
	}


	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songs = songRepository.findAll();
		return songs;
	}

	@Override
	public void updateSong(Song song) {
		songRepository.save(song);
	}


}






