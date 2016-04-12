package com.mustream.app.models.modules.PlaylistManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
//import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

import com.mustream.app.client.ApiException;
import com.mustream.app.client.api.MustreamApi;
import com.mustream.app.models.entities.CurrentUser;
import com.mustream.app.models.entities.Playlist;
import com.mustream.app.models.entities.Track;

/**
 * Created by Akilah Calliste-Woollard on 16-03-26.
 * Last modified by Akilah Calliste-Woollard on 16-04-11
 */

/**
* A PlaylistManager is Singleton responsible for storing all existing playlists and allowing users to 
* add new playlists, remove playlists and add or remove tracks from playlists
**/

public class PlaylistManager {
	private static PlaylistManager instance_;
	private Map<String, Playlist> playlists = new HashMap<String, Playlist>();
	private CurrentUser user = CurrentUser.getInstance();
	private boolean testing = true; //TODO only for development
	
	protected PlaylistManager() {
		loadPlaylists();
    }
	
	/**
    *
    * @return The sole instance of the playlist manager.
    */
   public static PlaylistManager getInstance_(){

       if (instance_ == null){
           instance_ = new PlaylistManager();
       }
       return instance_;
   }

 /**
 * Loads playlist database from txt file
 */	
   private void loadPlaylists() {	   
   
	   if (testing == true) {
		   Playlist testPlaylist = new Playlist("Test playlist");
		   List<Track> tempTracks = new ArrayList<Track>();
		   Track fakeTrack = new Track();
		   fakeTrack.setName("Test Track");
		   List<String> artists = new ArrayList<String>();
		   artists.add("Mustream team");
		   fakeTrack.setArtists(artists);
		   fakeTrack.setAlbum("MuStream tracks");
		   tempTracks.add(fakeTrack);	   
		   testPlaylist.setTracks(tempTracks);
		   playlists.put("Test playlist", testPlaylist); 
	   }
	   else {
		   try{
			   List<Playlist> tempUserPlaylists = 
					   MustreamApi.getInstance_().getAllPlaylists(user.getAccessToken(), 
							   user.getId());
			   for (Playlist pl : tempUserPlaylists){
				   playlists.put(pl.getName(), pl);
			   }
		   } catch(ApiException e) {
			   //TODO
		   }	  
	   }
   }
   
   public boolean noPlaylists()
   {
	   if (playlists.isEmpty())
		   return true;
	   else
		   return false;
   }
	
    /**
     * Removes an existing playlist from the database 
     * @param playlist The name of the playlist to be removed
     */	
	public void deletePlaylist(String playlist) {
		if(playlistExists(playlist)) {
//			try {
//				MustreamApi.getInstance_().deletePlaylist(user.getAccessToken(), user.getId(), playlists.get(playlist).getId());
				playlists.remove(playlist);
//			} catch (ApiException e) {
//				//TODO
//			}	
		}
			
		
	}
	
    /**
     * Rename an existing playlist
     * @param playlist The name of the playlist to be removed
     */	
	public void renamePlaylist(String oldName, String newName) {
		if(playlistExists(oldName)) {
//			try {
//				MustreamApi.getInstance_().updatePlaylist(user.getAccessToken(), user.getId(), playlists.get(oldName).getId(), newName);
				Playlist temp = playlists.get(oldName);
				temp.setName(newName);
				playlists.remove(oldName);
				playlists.put(newName, temp);
//			} catch (ApiException e) {
//				//TODO
//			}
			
		}
			
		
	}
    /**
     * Adds a new playlist from the database (only one playlist of a given name can exist)
     * Returns true if the playlist was added and false is the playlist already exists
     * @param name The name of the playlist to be added
     */	
	public void createPlaylist(String name) {

		if(playlistExists(name)) {
			//TODO
		}
		else {
//			try {
//			Playlist temp = MustreamApi.getInstance_().createPlaylist(user.getAccessToken(), user.getId(), name); //new Playlist(name);
			Playlist temp = new Playlist(name);
			playlists.put(name, temp);
//			} catch(ApiException e) {
//				//TODO
//			}	
		}
	}
    /**
     * Check is a playlist exists in the Current User's playlists
     * @param name : the name of the track to be added
     */		
	private boolean playlistExists(String name) {	
		if(playlists.containsKey(name))
			return true;
		else
			return false;
	}
	
    /**
     * Adds a track(s) to an existing playlist
     * @param name : the name of the track to be added
     * @param playlist : the name of the playlist to which the song will be added
     */		
	public void addTracks(List<Track> tracks, String playlist) {		
			if(playlistExists(playlist)) {			
				Playlist tempPlaylist = playlists.get(playlist);
				//Modify the server version of the playlist
//				List<String> uris = getUris(tracks);
				
//				try{
//					MustreamApi.getInstance_().addTrackstoPlaylist(user.getAccessToken(), user.getId(), tempPlaylist.getId(), uris, uris);
//				} catch (ApiException e)
//				{
//					//TODO
//				}
				
				
				//Modify the local version of the playlist
				//TODO could be replaced with "getPlaylist" from the API
				List<Track> tempTracks = tempPlaylist.getTracks();
				
				for(Track t : tracks) {
					tempTracks.add(t);
				}				
				
				tempPlaylist.setTracks(tempTracks);
				
			}
			else {
				//TODO
			}
	}
	
	//TODO comments
	private List<String> getUris(List<Track> tracks) {
		List<String> playlistUris = new ArrayList<String>();
		for(Track t : tracks) {
			playlistUris.add(t.getUri());
		}
		return playlistUris;
	}
	
    /**
     * Remove a a track to an existing playlist
     * @param name : the name of the track to be removed
     * @param playlist : name of the playlist from which the song will be removed
     */		
	public void removeTracks(List<Track> tracks, String playlist) {
		if(playlistExists(playlist)) {
		//Modify the server version of the playlist
		Playlist tempPlaylist = playlists.get(playlist);
//		List<String> uris = getUris(tracks);
		//TODO when server is working
//		try{
//			MustreamApi.getInstance_().removeTracksfromPlaylist(user.getAccessToken(), user.getId(), tempPlaylist.getId(), uris, uris);
//		} catch (ApiException e)
//		{
//			//TODO
//		}
		
		
		//Modify the local version of the playlist
		//TODO could be replaced with "getPlaylist" from the API
		List<Track> tempTracks = tempPlaylist.getTracks();
		
		for(Track t : tracks) {
			tempTracks.remove(t);
		}				
		
		tempPlaylist.setTracks(tempTracks);
		
		}
		else {
			//TODO
		}
	}
	
    /**
     * Returns the map of existing playlists
     */	
	public List<Playlist> getPlaylists() {
		
		List<Playlist> tempList = new ArrayList<Playlist>();
		if (playlists.isEmpty())
			return tempList;
		else {
			for (String plName: playlists.keySet()) {
				tempList.add(playlists.get(plName));
			}
			return tempList;
		}
	}
	
    /**
     * Returns the map of existing playlists
     */	
	public List<Track> getPlaylistTracks(String playlist) {
		List<Track> tempList = new ArrayList<Track>();
		if (playlists.isEmpty())
			return tempList;
		else {
			tempList = (playlists.get(playlist)).getTracks();
			return tempList;
		}
			
	}
	
}

 
