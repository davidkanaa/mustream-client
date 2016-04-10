package com.mustream.app.models.modules.PlaylistManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.mustream.app.models.entities.Playlist;
import com.mustream.app.models.entities.Track;
import com.mustream.app.rcp.parts.PlaylistPart;

/**
 * Created by Akilah Calliste-Woollard on 16-03-26.
 * Last modified by Akilah Calliste-Woollard on 16-03-28
 */

/**
* A PlaylistManager is Singleton responsible for storing all existing playlists and allowing users to 
* add new playlists, remove playlists and add or remove tracks from playlists
**/

public class PlaylistManager {
	private Map<String,Playlist> playlists;
	private File database;
	private static PlaylistManager instance_;
//	private String databaseDir;
	
	//
	private PlaylistPart playlistp;
	
	public PlaylistManager() {
       /* playlists = new HashMap<String,Playlist>();
//      databaseDir = System.getProperty("user.dir");
        
        playlistp = new PlaylistPart();
        
       try {
    	   //           BufferedReader reader = new BufferedReader(new FileReader("MuStreamDatabase.txt"));

           BufferedReader reader = new BufferedReader(new FileReader(playlistp.getPlaylistName()));
    	   this.loadPlaylists(reader);
       } catch (FileNotFoundException ex){
        	database = new File(playlistp.getPlaylistName());
       }
       //Pour le TP2 on va supposer qu'il y a juste une playlist
       this.createPlaylist("Playlist");*/
    }
	
//	method to create a playlist file of tracks
	public void createPlaylistFile(){
		 playlists = new HashMap<String,Playlist>();
//	      databaseDir = System.getProperty("user.dir");
	        
	        playlistp = new PlaylistPart();
	        
	       try {
	    	   //           BufferedReader reader = new BufferedReader(new FileReader("MuStreamDatabase.txt"));

	           BufferedReader reader = new BufferedReader(new FileReader(playlistp.getPlaylistName() + ".txt"));
	    	   this.loadPlaylists(reader);
	       } catch (FileNotFoundException ex){
	        	database = new File(playlistp.getPlaylistName()+ ".txt");
	       }
	       //Pour le TP2 on va supposer qu'il y a juste une playlist
	       this.createPlaylist("Playlist");
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
	public void loadPlaylists(BufferedReader reader) {
		String dbLine = null;
		try {
	    	while ((dbLine = reader.readLine()) != null) { 
	    		String[] playlistString = dbLine.split("(;Track\\{)");
	    		String name = playlistString[0];
	    		this.createPlaylist(name);
	    		List<Track> tempTracks = new ArrayList<Track>();
	    		int trackPos;
	    		for (trackPos=1; trackPos < playlistString.length;trackPos++){
	    			String[] trackInfo = playlistString[trackPos].split("(\\}\\{)");
	    			tempTracks.add(new Track());
	    			int i = 0;
	    			tempTracks.get(trackPos-1).setId(trackInfo[i]);
	    			tempTracks.get(trackPos-1).setName(trackInfo[++i]);
	    			tempTracks.get(trackPos-1).setUri(trackInfo[++i]);
	    			tempTracks.get(trackPos-1).setAlbum(trackInfo[++i]);
	    			List<String> artists = new ArrayList<String>();
	    			for (String artist: trackInfo[++i].split(","))
	    				artists.add(artist);
	    			tempTracks.get(trackPos-1).setArtists(artists);
	    			tempTracks.get(trackPos-1).setDuration(Long.parseLong(trackInfo[++i]));
	    			//System.out.println(tempTracks.get(trackPos-1));
	    	   }
	    		
	    	}	
	    }catch(Exception e){
	       e.printStackTrace();
	    } 
}
	
    /**
     * Removes an existing playlist from the database 
     * @param playlist The name of the playlist to be removed
     */	
	public void deletePlaylist(String playlist) {
			playlists.remove(playlist);
	}
    /**
     * Adds a new playlist from the database (only one playlist of a given name can exist)
     * Returns true if the playlist was added and false is the playlist already exists
     * @param name The name of the playlist to be added
     */	
	public boolean createPlaylist(String name) {
		if(playlists.containsKey(name)) {
			return false;
		}
		else {
			Playlist temp = new Playlist(name);
			playlists.put(name, temp);
			return true;
		}
	}
    /**
     * Adds a track to an existing playlist
     * @param name : the name of the track to be added
     * @param playlist : the name of the playlist to which the song will be added
     */		
	public void addTrack(Track track, String playlist) {
		(playlists.get(playlist)).tracks.add(track);
	}
	
    /**
     * Remove a a track to an existing playlist
     * @param name : the name of the track to be removed
     * @param playlist : name of the playlist from which the song will be removed
     */		
	public void removeTrack(Track track, String playlist) {
		(playlists.get(playlist)).tracks.remove(track);
	}
	
    /**
     * Returns the map of existing playlists
     */	
	public Set<String> getPlaylists() {
		return playlists.keySet();
	}
	
    /**
     * Returns the map of existing playlists
     */	
	public List<Track> getPlaylistTracks(String playlist) {
		return (playlists.get(playlist)).getTracks();
	}
	
	public void savePlaylists() {
		FileWriter fw;
		Playlist temp;
		database = new File("MuStreamDatabase.txt");
		database.delete();
		try {
			database = new File("MuStreamDatabase.txt");
			fw = new FileWriter(database);
			
			for (Map.Entry<String, Playlist> entry : playlists.entrySet()) {
				temp = entry.getValue();
				fw.write(String.format("%s",entry.getKey()));
				for (Track track: temp.tracks){
			    	fw.write(String.format(";Track"));		    	
			    	fw.write(String.format("{%s}",track.getId()));
			    	fw.write(String.format("{%s}",track.getName()));
			    	fw.write(String.format("{%s}",track.getUri()));
			    	fw.write(String.format("{%s}",track.getAlbum()));
			    	fw.write(String.format("{"));
			    	for(String artist: track.getArtists()) {
			    		fw.write(String.format("%s,",artist));
			    	}
			    	fw.write(String.format("}"));
			    	
			    	fw.write(String.format("{%d",track.getDuration()));
			    }
				fw.write(String.format("%n"));
			}
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		

		
	}
	
}

 
