package com.mustream.app.rcp.parts;

import com.mustream.app.models.entities.Item;
import com.mustream.app.models.entities.Track;
import com.mustream.app.models.modules.PlaylistManager.PlaylistManager;
import com.mustream.app.models.modules.searcher.Searcher;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

/**
 * @author Tx This part is responsible for the search in the different services
 *         available from this part you are also able to create playlist from
 *         the song you selected from your search
 */
public class SearchResultPart {
	private Searcher searcher;
	private Table searchTable;
	private String songString;
	private Text searchText;

	@PostConstruct
	public void createControls(Composite parent) {

		// creation of the layout parent with 3 widget in each line
		parent.setLayout(new GridLayout(3, false));

		// create the search text to take the input of the client for the
		// search
		searchText = new Text(parent, SWT.BORDER);
		searchText.setMessage("Search for tracks .......                   ");
		searchText.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));

		// create the button search onclick procede with the search in search
		// text has an input
		Button searchButton = new Button(parent, SWT.PUSH);
		searchButton.setText("Search");
		// position of the button search
		searchButton.setLayoutData(new GridData(SWT.LEAD, SWT.FILL, false, false, 1, 1));
		searchButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String terms = getSearchText().getText();
				if (terms.isEmpty()) {
					return;
				}
				getSearcher().search(terms);

				getSearchTable().removeAll();
				for (Item result : getSearcher().getResults()) {
					TableItem item = new TableItem(getSearchTable(), 0);
					item.setText(0, ((Track) result).getName());
					item.setText(1, ((Track) result).getAlbum());
					item.setText(2, ((Track) result).getArtists().toString());
				}
				for (int i = 0; i < 3; i++) {
					getSearchTable().getColumn(i).pack();
				}
				getSearchTable().layout(true);
			}
		});

		Button button2 = new Button(parent, SWT.PUSH);
		button2.setText("Add Track to Playlist");
		button2.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false));
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				(PlaylistManager.getInstance_()).addTrack(
						(Track) SearchResultPart.this.searcher.getResults().get(searchTable.getSelectionIndex()),
						"Playlist");
				PlaylistManager.getInstance_().savePlaylists();

			}
		});
		this.searcher = new Searcher();

		this.searchTable = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		this.searchTable.setHeaderVisible(true);
		this.searchTable.setLinesVisible(true);
		this.searchTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2));

		popupMenuSearch();

		String[] titles = { "Title", "Album", "Artist(s)" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(this.searchTable, 0);
			column.setText(titles[i]);
		}
	}

	public void showtable() {
		System.out.print(" make search ");
	}

	public String getSongString() {
		return this.songString;
	}

	public void setSongString(String songString) {
		this.songString = songString;
	}

	public Table getSearchTable() {
		return searchTable;
	}

	public Text getSearchText() {
		return searchText;
	}

	public Searcher getSearcher() {
		return this.searcher;
	}

	//
	// this is the creation of the popup menu for the search part
	// you have option to play the track, add them to playlist or queue
	// to create playlist
	private void popupMenuSearch() {
		// creation of a popup menu when you make a right click on the table
		Menu popupMenu = new Menu(searchTable);

		MenuItem playTrack = new MenuItem(popupMenu, SWT.NONE);
		playTrack.setText("Play track");

		MenuItem addTrackPlaylist = new MenuItem(popupMenu, SWT.CASCADE);
		addTrackPlaylist.setText("Add track to playlist");

		MenuItem addToQueue = new MenuItem(popupMenu, SWT.NONE);
		addToQueue.setText("Add to queue");

		Menu newMenu = new Menu(popupMenu);
		addTrackPlaylist.setMenu(newMenu);

		MenuItem showListPlaylist = new MenuItem(newMenu, SWT.CASCADE);
		showListPlaylist.setText("Show list of playlist");

		MenuItem createNewPlaylist = new MenuItem(newMenu, SWT.NONE);
		createNewPlaylist.setText("Create new playlist");
		createNewPlaylist.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

				PlaylistPart playlistpart = new PlaylistPart();
				playlistpart.popupDialogPlaylist();
				System.out.println("click");

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		Menu newMenu_2 = new Menu(popupMenu);
		showListPlaylist.setMenu(newMenu_2);

		MenuItem newM = new MenuItem(newMenu_2, SWT.NONE);
		newM.setText("new");

		searchTable.setMenu(popupMenu);
	}
}
