package com.mustream.app.rcp.parts;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
import com.mustream.app.models.entities.Track;
import com.mustream.app.models.modules.PlaylistManager.PlaylistManager;

/**
 * @author Tx The playlist part GUI shows the functionality of the playlist
 *         manager in this part you will be able to create, delete,rename
 *         playlist, delete track from playlist or add track to queue or and the
 *         playlist to play the track.
 */

public class PlaylistPart {
	private PlaylistManager playlistManager = null;
	private Table playlistTb;
	private Table tracksTb;
	private List<Track> defaultPlaylistTracks;

	private String playlistName;

	private PlaylistManager playlistman;

	@PostConstruct
	public void createControls(Composite parent) {

		parent.setLayout(new GridLayout(3, false));
		new Label(parent, 0);

		Label lblNewLabel = new Label(parent, SWT.NONE);
		lblNewLabel.setText("PLAYLIST");

		Label lblNewLabel_1 = new Label(parent, SWT.NONE);
		lblNewLabel_1.setText("TRACKS OF PLAYLIST");

		// create button to create playlist in playlist table
		Button createplaylistBtn = new Button(parent, SWT.NONE);
		createplaylistBtn.setText("Create playlist");
		
		// create this griddata to fix the width of the button in the part
		GridData gd = new GridData();
		gd.widthHint = 150;
		gd.verticalIndent=200 ;

		createplaylistBtn.setLayoutData(gd);

		createplaylistBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				popupDialogPlaylist();
			}

		});

		// create playlist table
		playlistTb = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL);
		// position of playlist in part
		GridData gd_table = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 6);
		gd_table.widthHint = 200;
		playlistTb.setLayoutData(gd_table);
		playlistTb.setHeaderVisible(true);
		playlistTb.setLinesVisible(true);
		popupMenuPlaylistTb();
		//
		// create tracks table to list tracks in playlist selected
		tracksTb = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);

		// position of playlist in part
		GridData gd_table_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 6);
		// gd_table_1.heightHint = 264;
		tracksTb.setLayoutData(gd_table_1);
		tracksTb.setHeaderVisible(true);
		tracksTb.setLinesVisible(true);
		popupMenuTracksTb();
		//
		// create the button to add a playlist to queue
		Button addPlaylistToQueue = new Button(parent, SWT.NONE);
		addPlaylistToQueue.setText("Add playlist to queue");

		GridData gd_1 = new GridData();
		gd_1.widthHint = 150;
		addPlaylistToQueue.setLayoutData(gd_1);
		addPlaylistToQueue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Pas impl�menter pour le TP2
			}
		});

		// create button to delete playlist in playlist table
		Button deletePlaylistBtn = new Button(parent, SWT.NONE);
		deletePlaylistBtn.setText("Delete playlist");
		deletePlaylistBtn.setLayoutData(gd_1);

		// create button to delete track in tracks table on click
		Button removeTrackFromPlaylist = new Button(parent, SWT.NONE);
		removeTrackFromPlaylist.setText("Remove track from playlist");
		removeTrackFromPlaylist.setLayoutData(gd_1);

		removeTrackFromPlaylist.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				PlaylistPart.this.playlistManager.removeTrack(defaultPlaylistTracks.get(tracksTb.getSelectionIndex()),
						"Playlist");
			}
		});

	

		String[] titles = { "Title", "Album", "Artist(s)" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(tracksTb, 0);
			column.setText(titles[i]);
		}

		playlistManager = PlaylistManager.getInstance_();

	}

	// creation of the popup dialog when you click to create a new playlist
	protected void popupDialogPlaylist() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		playlistName = JOptionPane.showInputDialog(frame, "Enter Playlist name:");

		playlistman = new PlaylistManager();
		playlistman.createPlaylistFile();

		System.out.println(playlistName);

	}

	public void showtable() {
		System.out.print(" display playlist ");
	}

	public Table getPlaylistTb() {
		return playlistTb;

	}

	public Table getTracksTb() {
		return tracksTb;
	}

	public PlaylistManager getPlaylistManager() {
		return PlaylistManager.getInstance_();
	}

	/**
	 * @return the playlistName
	 */
	public String getPlaylistName() {
		return playlistName;
	}

	/**
	 * @param playlistName
	 *            the playlistName to set
	 */
	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	// create the popup menu for the table of track when you make a right click
	// on it
	// you basically can add and remove song to playlist and add song to queue
	private void popupMenuTracksTb() {
		// creation of a popup menu when you make a right click on the table
		Menu popupMenu = new Menu(tracksTb);

		MenuItem playTrack = new MenuItem(popupMenu, SWT.NONE);
		playTrack.setText("Play track");

		MenuItem addToPlaylist = new MenuItem(popupMenu, SWT.NONE);
		addToPlaylist.setText("Add track to playlist");

		MenuItem addToQueue = new MenuItem(popupMenu, SWT.NONE);
		addToQueue.setText("Add track to queue");

		MenuItem removeFromPlaylist = new MenuItem(popupMenu, SWT.NONE);
		removeFromPlaylist.setText("Remove track from playlist");
		removeFromPlaylist.addSelectionListener(new SelectionListener() {

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

		tracksTb.setMenu(popupMenu);
	}

	// create the popup menu for the table of playlist when you make a right
	// click on it
	// you basically can create and delete playlist from list and add
	// playlist(track) to queue
	private void popupMenuPlaylistTb() {
		// creation of a popup menu when you make a right click on the table
		Menu popupMenu = new Menu(playlistTb);

		MenuItem playPlaylist = new MenuItem(popupMenu, SWT.NONE);
		playPlaylist.setText("Play playlist");

		MenuItem createPlaylist = new MenuItem(popupMenu, SWT.NONE);
		createPlaylist.setText("Create playlist");
		createPlaylist.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				popupDialogPlaylist();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		MenuItem renamePlaylist = new MenuItem(popupMenu, SWT.NONE);
		renamePlaylist.setText("Rename playlist");

		MenuItem deletePlaylist = new MenuItem(popupMenu, SWT.NONE);
		deletePlaylist.setText("Delete playlist");

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

		playlistTb.setMenu(popupMenu);
	}
}
