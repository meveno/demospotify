package com.neosoft.demospofity.service.helper;

import java.io.IOException;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.enums.ModelObjectType;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.special.SearchResult;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.data.search.SearchItemRequest;


public class SearchHelper extends AbstractHelper{

	public static Paging<AlbumSimplified> getAlbumSearchItems(String criteria) {
		SpotifyApi spotifyApi = auth();
		
		SearchItemRequest searchItemRequest = spotifyApi.searchItem(criteria, ModelObjectType.ALBUM.getType()).market(CountryCode.SE).limit(20).offset(0).build();
		Paging<AlbumSimplified> albums = null;
		try {
			 SearchResult searchResult = searchItemRequest.execute();
			 if(searchResult != null) {
				 albums = searchResult.getAlbums();
			 }
		} catch (SpotifyWebApiException | IOException e) {

		}
		return albums;		
	}
}
