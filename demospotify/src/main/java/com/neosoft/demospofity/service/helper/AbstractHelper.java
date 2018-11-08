package com.neosoft.demospofity.service.helper;

import java.io.IOException;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

public abstract class AbstractHelper {
	private static final String CLIENT_ID = "602a57ca5d0044379dda46992f50396c";
	private static final String CLIENT_SECRET = "119ff59712b14f9dafaf2eeffd508b40";
	
	public static SpotifyApi auth() {
		
		SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(CLIENT_ID).setClientSecret(CLIENT_SECRET).build();
		ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
		
		try {
			ClientCredentials clientCredentials = clientCredentialsRequest.execute();
			spotifyApi.setAccessToken(clientCredentials.getAccessToken());
			System.out.println("Reçu un access token! " + clientCredentials.getAccessToken());
		} catch (SpotifyWebApiException | IOException e) {

		}
		
		return spotifyApi;
	}
}
