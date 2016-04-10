package com.mustream.app.rcp.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.workbench.UIEvents.TrimmedWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Alex Toussaint created in ... the LeftPart of the RCP GUI holds the
 *         id of all the parts available in the GUI and some of the buttons to
 *         make them visible.
 */

public class LeftPart {
	// the id of all the parts in the application

	private static final String PSEARCH = "com.mustream.app.rcp.part.searchresult";
	private static final String PSETTINGS = "com.mustream.app.rcp.part.settings";
	private static final String PPLAY = "com.mustream.app.rcp.part.play";
	private static final String PQUEUE = "com.mustream.app.rcp.part.queue";
	private static final String PPLAYLIST = "com.mustream.app.rcp.part.playlist";
	private static final String PLOGIN = "com.mustream.app.rcp.part.login";
	private static final String PLEFT = "com.mustream.app.rcp.part.left";

	// a list of the parts to control the visibility of each part
	String[] enumpart = { PSEARCH, PSETTINGS, PPLAY, PQUEUE, PPLAYLIST };

	@Inject
	private static EPartService partService;
	TrimmedWindow window;
	EModelService service;
	MPartSashContainerElement element;
	MPartSashContainer sash;

	@PostConstruct
	public void postConstruct(Composite parent) {

		//
		GridLayout gridLayout = new GridLayout(1, false);
		parent.setLayout(gridLayout);

		// create the button for now playing
		Button nowPlayingButtonPart = new Button(parent, SWT.NONE);
		nowPlayingButtonPart.setText("Now playing");
		nowPlayingButtonPart.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		//
		// set the button to a fixes size
		GridData gd = new GridData();
		gd.widthHint = 150;
		gd.verticalSpan = 8;
		nowPlayingButtonPart.setLayoutData(gd);

		// on click show playing part to visualize the track that is playing in
		// the moment
		// along with the name of the artist and the song
		nowPlayingButtonPart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				showNowPlayingPart();

			}
		});

		// Creation and position of button queue
		Button queueButtonPart = new Button(parent, SWT.PUSH);
		queueButtonPart.setText("Queue");
		queueButtonPart.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		queueButtonPart.setLayoutData(gd);

		// on click make queue part visible
		queueButtonPart.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				showNowQueuePart();

			}
		});

		// Creation and position of button search
		Button searchButtonPart = new Button(parent, SWT.PUSH);
		searchButtonPart.setText("Search Screen");
		searchButtonPart.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		searchButtonPart.setLayoutData(gd);

		// on click show part
		searchButtonPart.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				showNowSearchPart();
			}
		});

		// Creation and position of button Playlist
		Button playlistButtonPart = new Button(parent, SWT.PUSH);
		playlistButtonPart.setText("Playlist");
		playlistButtonPart.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 2));

		playlistButtonPart.setLayoutData(gd);

		// on click show playlist part
		playlistButtonPart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				showNowPlaylistPart();

			}
		});

		// make all the parts invisible and
		// makePartInvisible();

		// then show the Now playing part as the welcome part
		// showNowLoginPart();
		//
		// showNowLeftPart();
		// then show the Now playing part as the welcome part
		// showNowPlayinPart();

	}

	// TODO Auto-generated method stub
	public void showNowQueuePart() {

		makePartInvisible();
		MPart part = LeftPart.getPartService().findPart(PQUEUE);
		LeftPart.getPartService().showPart(part, EPartService.PartState.VISIBLE).setVisible(true);

	}

	// method called to show the search part responsible for the search
	// of tracks in the available services
	public void showNowSearchPart() {

		makePartInvisible();
		MPart part = LeftPart.getPartService().findPart(PSEARCH);
		LeftPart.getPartService().showPart(part, EPartService.PartState.VISIBLE).setVisible(true);

	}

	// method call to show the login part when the application
	public void showNowLoginPart() {
		makePartInvisible();

		MPart part = getPartService().findPart(PLOGIN);
		getPartService().showPart(part, EPartService.PartState.VISIBLE).setVisible(true);
	}

	// method called to show the left part
	public void showNowLeftPart() {
		hideNowLoginPart();
		makePartInvisible();
		MPart part = getPartService().findPart(PLEFT);
		getPartService().showPart(part, EPartService.PartState.VISIBLE).setVisible(true);
	}
	public void hideNowLeftPart() {

		
		MPart part = getPartService().findPart(PLEFT);
		getPartService().hidePart(part);
	}

	public void showNowPlayingPart() {
		makePartInvisible();

		MPart part = getPartService().findPart(PPLAY);
		getPartService().showPart(part, EPartService.PartState.VISIBLE).setVisible(true);
	}

	public void showNowSettingsPart() {
		makePartInvisible();
		MPart part = getPartService().findPart(PSETTINGS);
		getPartService().showPart(part, EPartService.PartState.VISIBLE).setVisible(true);
	}

	public void showNowPlaylistPart() {
		makePartInvisible();
		MPart part = LeftPart.getPartService().findPart(PPLAYLIST);
		LeftPart.getPartService().showPart(part, EPartService.PartState.VISIBLE).setVisible(true);

	}

	public void hideNowLoginPart() {
		
		MPart part = LeftPart.getPartService().findPart(PLOGIN);
		getPartService().hidePart(part);

	}
	
	public void makePartInvisible() {
		for (int i = 0; i < this.enumpart.length; i++) {
			MPart part = getPartService().findPart(this.enumpart[i]);
			getPartService().hidePart(part);
		}
	}

	public void makePartVisible() {
		for (int i = 0; i < this.enumpart.length; i++) {
			MPart part = getPartService().findPart(this.enumpart[i]);
			getPartService().showPart(part, EPartService.PartState.VISIBLE).setVisible(true);
		}
	}

	public static String getPsettings() {
		return PSETTINGS;
	}

	public static String getSearchResult() {
		return PSEARCH;
	}

	public static EPartService getPartService() {
		return partService;
	}

}
