package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.Song;

public interface SongService {

	  public void saveSong(Song song);

	  boolean songExists(Song song);

	 public List<Song> fetchAllSongs();

	 public void updateSong(Song song);

	

}
