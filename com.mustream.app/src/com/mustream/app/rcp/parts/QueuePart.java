package com.mustream.app.rcp.parts;

import javax.annotation.PostConstruct;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;

/**
 * @author 
 * Queue part will be able to create temporarily playlist of tracks 
 */
public class QueuePart
{
  private Table queueTb;
  
  @PostConstruct
  public void createPartControl(Composite parent)
  {
    parent.setLayout(new GridLayout(1, false));
    
	queueTb = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
	queueTb.setHeaderVisible(true);
	queueTb.setLinesVisible(true);
	queueTb.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

	popupMenuQueue();
	
	queueTb.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseUp(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseDown(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseDoubleClick(MouseEvent e) {
			// on doubl click on track. specific track suppose to play 
			
		}
	});
    
  }

//  
//  popup menu for the queue part
//  possibility to play,remove track or add it to a playlist
private void popupMenuQueue() {
	// TODO Auto-generated method stub
	Menu popupMenu = new Menu(queueTb);
	
	MenuItem playTrack = new MenuItem(popupMenu, SWT.NONE);
	playTrack.setText("Play track");

	MenuItem addToPlaylist = new MenuItem(popupMenu, SWT.NONE);
	addToPlaylist.setText("Add track to playlist");

	MenuItem removeFromQueue = new MenuItem(popupMenu, SWT.NONE);
	removeFromQueue.setText("Add track to queue");
	
    queueTb.setMenu(popupMenu);
	
}
  
  
}
