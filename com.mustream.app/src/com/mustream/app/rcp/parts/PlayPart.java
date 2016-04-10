package com.mustream.app.rcp.parts;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author Tx
 * the play part suppose to show the image of the track if there is one and the title and the name
 * of the artist if possible
 */
public class PlayPart
{
  /**
 * @param parent
 */
@PostConstruct
  public void createControls(Composite parent)
  {
    parent.setLayout(new GridLayout(1, false));
// 
//    we create one label to hold the image
    Label lblImgSong = new Label(parent, SWT.NONE);
    
    GridData gd_lblImgSong = new GridData(SWT.CENTER, SWT.FILL, true, false, 1, 1);
    gd_lblImgSong.heightHint = 176;
    lblImgSong.setLayoutData(gd_lblImgSong);
    lblImgSong.setText("IMAGE");
//  
// create a label to show the title of the track  
    Label lblSongTitle = new Label(parent, SWT.NONE);
    lblSongTitle.setText(" SONG NAME");
//
//    this label show the name of the artist of the track
    Label lblArtistName = new Label(parent, SWT.NONE);
    lblArtistName.setText("ARTIST NAME");
  }
}
