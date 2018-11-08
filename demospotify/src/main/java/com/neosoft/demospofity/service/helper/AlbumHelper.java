package com.neosoft.demospofity.service.helper;

import java.io.IOException;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Album;
import com.wrapper.spotify.requests.data.albums.GetSeveralAlbumsRequest;


public class AlbumHelper extends AbstractHelper{

	public static Album[] getAlbums(String[] ids) {
		SpotifyApi spotifyApi = auth();
		
		GetSeveralAlbumsRequest getSeveralAlbumsRequest = spotifyApi.getSeveralAlbums(ids).market(CountryCode.SE).build();
		
		Album[] albums = null;
		try {
			 albums = getSeveralAlbumsRequest.execute();

		} catch (SpotifyWebApiException | IOException e) {

		}
		return albums;		
	}
}
