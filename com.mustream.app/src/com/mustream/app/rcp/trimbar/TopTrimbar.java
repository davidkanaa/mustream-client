package com.mustream.app.rcp.trimbar;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class TopTrimbar {
	
	@PostConstruct
	public void createGui(Composite com ) {
		 com.setLayout(new GridLayout(1, false));
		// com.setLayoutData(new GridData( 1,1,f));
		    
		 Label lblNewLabel = new Label(com, SWT.NONE);
			lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
			lblNewLabel.setText("New Label");
			lblNewLabel.setBounds(1, 1, SWT.FILL, 3);
		
	}
}