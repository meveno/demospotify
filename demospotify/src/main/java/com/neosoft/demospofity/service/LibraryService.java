package com.neosoft.demospofity.service;

import java.util.List;

import com.neosoft.demospofity.entity.Album;
import com.neosoft.demospofity.entity.Library;
import com.neosoft.demospofity.entity.bean.AlbumBean;

public interface LibraryService {

	void addAlbumToLibrary(String idAlbumSpotify);
	
	void deleteAlbumFromLibrary(String idAlbumSpotify);
	
	List<AlbumBean> getAllAlbumsFromLibrary();
	
	void addOrRemoveFavoris(String idAlbumSpotify, boolean favoris);
	
	Library getLibrary();
}
