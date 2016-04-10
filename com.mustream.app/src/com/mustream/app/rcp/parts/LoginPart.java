package com.mustream.app.rcp.parts;

import javax.annotation.PostConstruct;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import com.mustream.app.rcp.parts.LeftPart;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

//
/**
 * @author Tx the login part allow the user to get access to the application by
 *         using a username and password or by creating one if it doens't have
 *         or want a new account
 */
public class LoginPart {
	private Text usernameText;
	private Text passwordText;
	private LeftPart left;
	private Button nextButton;
	private Button loginButton;
	private Group group;

	private int i = 1;

	@PostConstruct
	public void createControls(Composite parent) {

		// call those methods from the leftpart to make invisible all the parts
		// and the leftpart itself so the login part will only be visible when
		// we run the MUSTREAM
		left = new LeftPart();
		left.makePartInvisible();
		left.hideNowLeftPart();

		// set the number of widget per row in the parent
		parent.setLayout(new GridLayout(1, false));

		// create a label for the name of the app on the login screen
		Label loginLabel = new Label(parent, SWT.NONE);
		loginLabel.setText("MuStream");
		// indent the first label
		GridData usernameIndent = new GridData();
		usernameIndent.verticalIndent = 150;
		usernameIndent.horizontalAlignment = SWT.CENTER;
		loginLabel.setLayoutData(usernameIndent);

		// loginLabel.setFont();

		// create the label and the text for the username field
		Label usernameLabel = new Label(parent, SWT.NONE);
		usernameLabel.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false, false, 1, 1));
		usernameLabel.setText("USERNAME");

		usernameText = new Text(parent, SWT.BORDER);
		usernameText.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, false, 1, 1));
		usernameText.setMessage("enter the name of the account on Mustream       ");

		// new Label(parent, SWT.NONE);

		// create the label and the text for the password field
		Label passwordLabel = new Label(parent, SWT.NONE);
		passwordLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		passwordLabel.setText("PASSWORD");

		passwordText = new Text(parent, SWT.BORDER);
		passwordText.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		passwordText.setMessage("enter the password of the account on Mustream");
		passwordText.setEchoChar('*');

		// create a label that provides a message if the username and password
		// are correct "access granted"
		// if not " access denied/ check username or password
		Label accessMessageLabel = new Label(parent, SWT.NONE);
		accessMessageLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		accessMessageLabel.setText("                                                                             ");

		// on click: login button gives user access whenever the username and
		// password entered are correct
		// if not the application return an error message to the user asking to
		// verify the information provided

		loginButton = new Button(parent, SWT.PUSH);
		loginButton.setText("Login");
		// set the size and the position of the buttons on the composite
		// and also in the group widget for the new user account option
		GridData Buttongd = new GridData();
		Buttongd.horizontalAlignment = SWT.CENTER;
		Buttongd.widthHint = 110;
		Buttongd.verticalIndent = 10;

		loginButton.setLayoutData(Buttongd);
		//
		loginButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				// compare the username and password entered to the one found in
				// the database if existed
				// to give access or no to the current user
				if ("admin".equals(usernameText.getText()) && "admin".equals(passwordText.getText())) { // &&

					accessMessageLabel.setText("Welcome " +" " + usernameText.getText()+"          . Click on Next");
					nextButton.setEnabled(true);

				} else {
					// label return a message error
					if (i < 3) {
						accessMessageLabel.setText(i + " :" + "Access denied & check username or password");
						i++;
					} else if (i == 3) {
						accessMessageLabel.setText("WARNING: try exceeded /Create new account");
						loginButton.setEnabled(false);

					}
				}
			}

		});

		// on click button open the app after if credentials are correct
		nextButton = new Button(parent, SWT.PUSH);
		nextButton.setText("Next");
		// nextButton.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false,
		// false, 1, 1));
		nextButton.setLayoutData(Buttongd);
		nextButton.setEnabled(false);
		nextButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				left.showNowLeftPart();
				left.showNowPlayingPart();
				left.hideNowLoginPart();
			}
		});

		// create account for creating a new account in other to have access to
		// the app and the services
		Button newUserButton = new Button(parent, SWT.PUSH);
		newUserButton.setText("New user account");
		// newUserButton.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false,
		// false, 1, 1));
		newUserButton.setLayoutData(Buttongd);

		newUserButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				group.setVisible(true);
				nextButton.setEnabled(false);

			}
		});

		// create a group widget to hold the text and button for new user to create new user account
		// it will be visible when you click on new account
//		once a unique username and password are entered and the button is clicked a label message will tell you if
//		has been successfull or not

		group = new Group(parent, SWT.NULL);
		group.setText("New user");

		GridLayout gridLayoutGroup = new GridLayout();
		gridLayoutGroup.numColumns = 2;
		group.setLayout(gridLayoutGroup);
		group.setVisible(false);

		GridData gridData = new GridData();

		gridData.horizontalAlignment = SWT.CENTER;
		group.setLayoutData(gridData);

		Label newUsernameLabel = new Label(group, SWT.NONE);
		newUsernameLabel.setText("New Username");
		newUsernameLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));

		Text newUsernameText = new Text(group, SWT.SINGLE | SWT.BORDER);
		newUsernameText.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		newUsernameText.setMessage("enter a choosen name                                   ");

		Label newPasswordLabel = new Label(group, SWT.NONE);
		newPasswordLabel.setText("New Password");
		newPasswordLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));

		Text newPasswordText = new Text(group, SWT.SINGLE | SWT.BORDER);
		newPasswordText.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		newPasswordText.setMessage("enter a choosen password                              ");

		Label messageUserAccount = new Label(group, SWT.NONE);
		messageUserAccount.setText(" ");
		messageUserAccount.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		//
		//on click this button will verify in the database if the information entered are unique 
//		or if the exist already before creating new profile
		Button createAccountButton = new Button(group, SWT.PUSH);
		createAccountButton.setText("create account");
		GridData userBtnConf = new GridData();
		userBtnConf.widthHint = 110;
		userBtnConf.horizontalAlignment = SWT.RIGHT;
		userBtnConf.verticalIndent = 10;

		createAccountButton.setLayoutData(userBtnConf);

		createAccountButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				//
				if ("admin".equals(newUsernameText.getText()) && "admin".equals(newPasswordText.getText())) { // &&

					messageUserAccount.setText("Created successfully !!!");

				} else {
					// label return a message error

					messageUserAccount.setText("Username already exist. Please try new one");

				}
			}

		});
		//
		// click on cancel if the user decided not create new account
		Button cancelAccountButton = new Button(group, SWT.PUSH);
		cancelAccountButton.setText("Cancel");
		cancelAccountButton.setLayoutData(userBtnConf);

		cancelAccountButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				group.setVisible(false);
			}
		});

	}



	@Focus
	public void onFocus() {
	}
}
