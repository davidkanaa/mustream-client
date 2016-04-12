package com.mustream.app.rcp.parts;

//import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.mustream.app.models.entities.Item;
import com.mustream.app.models.entities.Playlist;
import com.mustream.app.models.entities.Track;
import com.mustream.app.models.modules.PlaylistManager.PlaylistManager;

/**
 * @author Tx The playlist part GUI shows the functionality of the playlist
 *         manager in this part you will be able to create, delete,rename
 *         playlist, delete track from playlist or add track to queue or and the
 *         playlist to play the track.
 */

public class PlaylistPart {
	private static PlaylistPart instance_ = null;
	private Table playlistTable;
	private Table tracksTable;
	private List<Track> playlistTracks;
	private List<Track> selectedTracks = new ArrayList<Track>();
	private String playlistName;
//	private PlaylistManager playlistman = null; // 

//	protected PlaylistPart(){
//		
//	}
	public static PlaylistPart getInstance_(){
		if(instance_ == null ) 
			instance_ = new PlaylistPart();
		return instance_;
	}
	@PostConstruct
	public void createControls(Composite parent) {

		parent.setLayout(new GridLayout(3, false));
		new Label(parent, 0);

		Label lblNewLabel = new Label(parent, SWT.NONE);
		lblNewLabel.setText("PLAYLIST");

		Label lblNewLabel_1 = new Label(parent, SWT.NONE);
		lblNewLabel_1.setText("PLAYLIST TRACKS");
		
		// create this griddata to fix the width of the button in the part
				GridData gd = new GridData();
				gd.widthHint = 150;
				gd.verticalIndent= 200 ;
				
		//Create a text entry for users to enter to playlist name
//		Text newPlaylistName = new Text(parent, SWT.BORDER);
//		newPlaylistName.setMessage("New playlist name...");
		//newPlaylistName.setLayoutData(gd);
		
		// create button to create playlist in playlist table
		Button createplaylistBtn = new Button(parent, SWT.NONE);
		createplaylistBtn.setText("Create playlist");
		
		
		createplaylistBtn.setLayoutData(gd);
		createplaylistBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//TODO UNCOMMENT ONCE ISSUE WITH POP-UP FIXED
				//popupDialogPlaylist();
//				String name = newPlaylistName.getText();
//				PlaylistManager.getInstance_().createPlaylist(name);
//				updatePlaylistTable();
			}

		});

		// Create table of current user's playlists
		//TODO added SWT.SINGLE for single line at a time - akcw
		playlistTable = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.SINGLE);
		
		// Position of playlist in part		
		GridData gd_table = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 6);
		gd_table.widthHint = 200;
		playlistTable.setLayoutData(gd_table);
		playlistTable.setHeaderVisible(true);
		playlistTable.setLinesVisible(true);
		popupMenuPlaylistTb();
		updatePlaylistTable();
		//When a playlist is selected, display it's tracks.
		playlistTable.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		    	  TableItem[] selectedPlaylist = playlistTable.getSelection();
		    	  playlistName = selectedPlaylist[0].getText(0);
		    	  updateTracksTable();
		        }
		 });

		
		// create tracks table to list tracks in playlist selected
		tracksTable = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		// position of playlist in part
		GridData gd_table_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 6);
				
		// gd_table_1.heightHint = 264;
		tracksTable.setLayoutData(gd_table_1);
		tracksTable.setHeaderVisible(true);
		tracksTable.setLinesVisible(true);
		popupMenuTracksTb();
		
		// Create the button to add a playlist to queue
		Button addPlaylistToQueue = new Button(parent, SWT.NONE);
		addPlaylistToQueue.setText("Add playlist to queue");
		GridData gd_1 = new GridData();
		gd_1.widthHint = 150;
		addPlaylistToQueue.setLayoutData(gd_1);
		addPlaylistToQueue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//TODO
			}
		});

		//Create button to delete playlist in playlist table
		Button deletePlaylistBtn = new Button(parent, SWT.NONE);
		deletePlaylistBtn.setText("Delete playlist");
		deletePlaylistBtn.setLayoutData(gd_1);
		deletePlaylistBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				PlaylistManager.getInstance_().deletePlaylist(playlistName);
				updatePlaylistTable();
			}
		});

		//Create button to delete track in tracks table on click
		Button removeTrackFromPlaylist = new Button(parent, SWT.NONE);
		removeTrackFromPlaylist.setText("Remove track from playlist");
		removeTrackFromPlaylist.setLayoutData(gd_1);
		removeTrackFromPlaylist.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				getSelectedTracks();
				PlaylistManager.getInstance_().removeTracks(selectedTracks, playlistName);
				updateTracksTable();
			}
		});	
		
//		//Create button to add tracks to given playlist
//		Button addTrackToPlaylist = new Button(parent, SWT.NONE);
//		addTrackToPlaylist.setText("Add track(s) to playlist");
//		addTrackToPlaylist.setLayoutData(gd_1);
//		addTrackToPlaylist.addSelectionListener(new SelectionAdapter() {
//		public void widgetSelected(SelectionEvent e) {
//			getSelectedTracks();
//			
//			PlaylistPart.this.playlistman.addTracks(selectedTracks, playlistName);
//						
//			}
//		});	

		String[] titles = { "Title", "Album", "Artist(s)" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(tracksTable, 0);
			column.setText(titles[i]);
		}	

	}
	
	private void getSelectedTracks() {
		selectedTracks.clear();
		for (int i : tracksTable.getSelectionIndices())
		{
			selectedTracks.add(playlistTracks.get(i));
		}
	}

	// creation of the popup dialog when you click to create a new playlist
	protected void popupDialogPlaylist() {
		
		JFrame frame = new JFrame();
//		playlistName = JOptionPane.showInputDialog(frame, "Enter Playlist name:");
//    	PlaylistManager.getInstance_().createPlaylist(playlistName);
//		//System.out.println(playlistName);
		
		//Object newPlaylist = new Object();
		String newPlaylistName = (String)JOptionPane.showInputDialog(
		                    frame,
		                    "Create New Playlist",
		                    "Input new playlist name");
		PlaylistManager.getInstance_().createPlaylist(newPlaylistName);
	
	}

//	public void showtable() {
//		System.out.print(" display playlist ");
//	}
	
	public void updatePlaylistTable() {
		if (!PlaylistManager.getInstance_().noPlaylists()){
			playlistTable.removeAll();
			for (Playlist playlist : PlaylistManager.getInstance_().getPlaylists()) {
				TableItem item = new TableItem(playlistTable, 0);
				item.setText(0, playlist.getName());
			}
		}
		playlistTable.layout(true);
		
	}
	
	private void updateTracksTable() {
		tracksTable.removeAll();
		playlistTracks = PlaylistManager.getInstance_().getPlaylistTracks(playlistName);
		for (Track track : playlistTracks) {
			TableItem item = new TableItem(tracksTable, 0);
			item.setText(0, track.getName());
			item.setText(1, track.getAlbum());
			item.setText(2, track.getArtists().toString());
		}
		
		for (int i = 0; i < tracksTable.getColumnCount(); i++) {
			tracksTable.getColumn(i).pack();
		}
		tracksTable.layout(true);
	}

	// create the popup menu for the table of track when you make a right click
	// on it
	// you basically can add and remove song to playlist and add song to queue
	private void popupMenuTracksTb() {
		// creation of a popup menu when you make a right click on the table
		Menu popupMenu = new Menu(tracksTable);

		MenuItem playTrack = new MenuItem(popupMenu, SWT.NONE);
		playTrack.setText("Play track(s)");
		playTrack.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				//TODO
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		MenuItem addToPlaylist = new MenuItem(popupMenu, SWT.CASCADE);
		addToPlaylist.setText("Add track(s) to playlist");
//		addToPlaylist.addSelectionListener(listPlaylists(popupMenu)); //TODO not needed
		
		listPlaylists(popupMenu, addToPlaylist);
			
		MenuItem addToQueue = new MenuItem(popupMenu, SWT.NONE);
		addToQueue.setText("Add track(s) to queue");
		addToQueue.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				//TODO
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		MenuItem removeFromPlaylist = new MenuItem(popupMenu, SWT.NONE);
		removeFromPlaylist.setText("Remove track(s) from playlist");
		removeFromPlaylist.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				getSelectedTracks();
				PlaylistManager.getInstance_().removeTracks(selectedTracks, playlistName);
				updateTracksTable();
			}
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		tracksTable.setMenu(popupMenu);
	}

	// create the popup menu for the table of playlist when you make a right
	// click on it
	// you basically can create and delete playlist from list and add
	// playlist(track) to queue
	private void popupMenuPlaylistTb() {
		// creation of a popup menu when you make a right click on the table
		Menu popupMenu = new Menu(playlistTable);

		MenuItem playPlaylist = new MenuItem(popupMenu, SWT.NONE);
		playPlaylist.setText("Play playlist");
		playPlaylist.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				//TODO
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		//TODO Problem with pop-up. 
		/*
		MenuItem createPlaylist = new MenuItem(popupMenu, SWT.NONE);
		createPlaylist.setText("Create playlist");
		createPlaylist.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				popupDialogPlaylist();
				updatePlaylistTable();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		}); */

		MenuItem renamePlaylist = new MenuItem(popupMenu, SWT.NONE);
		renamePlaylist.setText("Rename playlist");
		renamePlaylist.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				//TODO
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		MenuItem deletePlaylist = new MenuItem(popupMenu, SWT.NONE);
		deletePlaylist.setText("Delete playlist");
		deletePlaylist.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				PlaylistManager.getInstance_().deletePlaylist(playlistName);
				updatePlaylistTable();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		MenuItem addPlaylistToQueue = new MenuItem(popupMenu, SWT.NONE);
		addPlaylistToQueue.setText("Add playlist to queue");
		addPlaylistToQueue.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("click");

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		playlistTable.setMenu(popupMenu);
	}
	
	
	public void listPlaylists(Menu menu, MenuItem menuItem) {
		Menu newMenu_2 = new Menu(menu);
		menuItem.setMenu(newMenu_2);
		
		if (!PlaylistManager.getInstance_().noPlaylists()){
			for (Playlist playlist : PlaylistManager.getInstance_().getPlaylists()) {
				MenuItem item = new MenuItem(newMenu_2, SWT.NONE);
				item.setText(playlist.getName());
				item.addSelectionListener(new SelectionListener() {
					public void widgetSelected(SelectionEvent e) {
						PlaylistManager.getInstance_().addTracks(selectedTracks, playlist.getName());
						updateTracksTable();
					}
					public void widgetDefaultSelected(SelectionEvent e) {
						widgetSelected(e);
					}
				});
			}
		}
//		
//		SelectionListener playlistMenu = new SelectionListener() 
//		{
//			
//			
//			public void widgetSelected(SelectionEvent e) {
//				for (Playlist playlist : playlistman.getPlaylists()) {
//					MenuItem item = new MenuItem(menu, SWT.NONE);
//					item.setText(playlist.getName());
//					item.addSelectionListener(new SelectionListener() {
//						public void widgetSelected(SelectionEvent e) {
//							playlistman.addTracks(selectedTracks, playlist.getName());
//						}
//						public void widgetDefaultSelected(SelectionEvent e) {
//							widgetSelected(e);
//						}
//					});
//				}
//			}
//			
//			public void widgetDefaultSelected(SelectionEvent e) {
//				widgetSelected(e);
//			}
//		};
//		return playlistMenu;
	}
	
//	public void selectPlaylistAction() {
//		
//		public void widgetSelected(SelectionEvent e) {
//			playlistman.addTracks(selectedTracks, playlist.getName());
//		}
//		public void widgetDefaultSelected(SelectionEvent e) {
//			widgetSelected(e);
//		}
//	}
		
}
