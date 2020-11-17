package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GUI extends Application{
	
	public static void main(String [] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage loginStage) throws Exception {
		BorderPane rootPane = new BorderPane();
		Button btnLogin = new Button("Login");
		Button btnLoginAsGuest = new Button("Login as Guest");
		Button btnExit = new Button("Exit");
		GridPane inputFields = new GridPane();
		HBox btnContainer = new HBox();
		Label lblUsername = new Label("Username:");
		Label lblPassword = new Label("Password:");
		PasswordField pwdField = new PasswordField();
		TextField usnField = new TextField();

		
	/*
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (usnField.getText().isBlank() || pwdField.getText().isBlank()) {
					Alert infoDialog = new Alert(AlertType.ERROR,
							"Please ensure you have entered a username and password.", ButtonType.OK);
					infoDialog.showAndWait();
				} else {
					if (loadedBookstore.isUsersEmpty()) {
						String inputUsername = usnField.getText().toString();
						String inputPassword = pwdField.getText().toString();

						if (inputUsername.contentEquals("admin") && inputPassword.contentEquals("cse148")) {
							userAuthenticated = 0;
							bookstoreWindow();
							loginStage.close();
						} else {
							Alert infoDialog = new Alert(AlertType.ERROR,
									"No user list is present to verify login credentials, as no bookstore data file was found or one could not be successfully loaded. "
											+ "To sign in, click 'Login as Guest' or enter the administrator credentials.",
									ButtonType.OK);
							infoDialog.showAndWait();
						}
					} else {
						String inputUsername = usnField.getText().toString();
						String inputPassword = pwdField.getText().toString();

						if (inputUsername.contentEquals("admin") && inputPassword.contentEquals("cse148")) {
							userAuthenticated = 0;
							bookstoreWindow();
							loginStage.close();
						} else {
							for (int i = 0; i < loadedBookstore.getUsersLength(); i++) {
								User u = loadedBookstore.getUser(i);
								if (u.getUsername().contentEquals(inputUsername)
										&& u.getPassword().contentEquals(inputPassword)) {
									userAuthenticated = 1;
									authenticatedUser = loadedBookstore.getUser(i);
									bookstoreWindow();
									loginStage.close();
									return;
								}
							}
							Alert infoDialog = new Alert(AlertType.WARNING,
									"Username and password combination is invalid. "
											+ "Please enter a valid username and password or click 'Login as Guest'.",
									ButtonType.OK);
							infoDialog.showAndWait();
						}
					}
				}
			}
		});
		btnLoginAsGuest.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				userAuthenticated = 2;
				bookstoreWindow();
				loginStage.close();
			}
		});
		btnExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				loginStage.close();
			}
		});
	*/
		// these are in the order they are in for a reason, don't touch
		btnContainer.setPadding(new Insets(0, 0, 5, 20));
		btnContainer.setSpacing(5);
		inputFields.setHgap(5);
		inputFields.setVgap(5);
		inputFields.setPadding(new Insets(5, 0, 0, 5));
		inputFields.add(lblUsername, 0, 0);
		inputFields.add(usnField, 1, 0);
		inputFields.add(lblPassword, 0, 1);
		inputFields.add(pwdField, 1, 1);
		btnContainer.getChildren().addAll(btnLogin, btnLoginAsGuest, btnExit);

		rootPane.setCenter(inputFields);
		rootPane.setBottom(btnContainer);
		Scene loginScene = new Scene(rootPane, 240, 100);
		loginStage.setScene(loginScene);
		loginStage.setTitle("Login to Bookstore");
		loginStage.setResizable(false);
		loginStage.show();
	}
}
