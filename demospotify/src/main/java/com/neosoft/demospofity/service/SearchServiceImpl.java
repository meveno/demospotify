package com.neosoft.demospofity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.demospofity.entity.Album;
import com.neosoft.demospofity.entity.bean.AlbumBean;
import com.neosoft.demospofity.service.helper.SearchHelper;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private LibraryService libraryService;
	
	@Override
	public List<AlbumBean> searchAlbums(String criteria) {
		List<AlbumBean> results = new ArrayList<AlbumBean>();
		
		List<AlbumBean> albumsLibrary = libraryService.getAllAlbumsFromLibrary();
		
		Paging<AlbumSimplified> result = SearchHelper.getAlbumSearchItems(criteria);
		AlbumSimplified[] albums = result.getItems();
		
		for(AlbumSimplified album : albums) {
			
			AlbumBean albumBean = new AlbumBean();
			albumBean.setName(album.getName());
			albumBean.setAlbumType(album.getAlbumType());
			albumBean.setImages(album.getImages());
			albumBean.setArtists(album.getArtists());
			albumBean.setId(album.getId());
			
			for(AlbumBean albumLibrary : albumsLibrary) {
				if(album.getId().equals(albumLibrary.getId())) {
					albumBean.setInAlbumLibrary(true);
				}
			}
			
			results.add(albumBean);
		}
		
		return results;
	}

}
