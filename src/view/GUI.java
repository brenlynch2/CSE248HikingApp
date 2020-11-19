package view;

import java.util.LinkedList;
import history.HikingHistoryEntry;
import history.HikingHistoryStorageContainer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import trails.Trail;
import trails.TrailStorageContainer;
import users.TreeMapUserStorageContainer;
import users.User;
import utilities.TestingFunctions;

public class GUI extends Application{
	private static ObservableList<HikingHistoryEntry> driverListHistoryWindowResultsView = FXCollections.observableArrayList();
	private static ObservableList<Trail> driverListTrailSearchWindowResultsView = FXCollections.observableArrayList();
	private static TreeMapUserStorageContainer userList = new TreeMapUserStorageContainer();
	private static User authenticatedUser = null;
	private static TrailStorageContainer trailList = new TrailStorageContainer();
	//private static BackupContainer loadedContainer = null;
	
	public static void main(String [] args) {
		/*
		loadedContainer = DataIO.loadContainer();
		if(loadedContainer != new BackupContainer()) {
			userList = (TreeMapUserStorageContainer)loadedContainer.getData(0);
			trailList = (TrailStorageContainer)loadedContainer.getData(1);
		}
		*/
		Application.launch(args);
	}
	public static void syncLists() {
		driverListHistoryWindowResultsView.clear();
		driverListTrailSearchWindowResultsView.clear();
		for(int i = 0; i < trailList.size(); i++) {
			driverListTrailSearchWindowResultsView.add(trailList.getTrail(i));
		}
		HikingHistoryStorageContainer currentContainer = authenticatedUser.getHistoryList();
		for(int i = 0; i < currentContainer.size(); i++) {
			driverListHistoryWindowResultsView.add(currentContainer.getEntry(i));
		}
	}
	public static void populateListsRandomly() {
		userList = TestingFunctions.testRunTreeMapUserStorageContainer();
		trailList = TestingFunctions.testRunTrailStorageContainer();
		Alert infoDialog = new Alert(AlertType.INFORMATION,
				"Both the trailList and the userList containers have been populated with random values.", ButtonType.OK);
		infoDialog.showAndWait();
	}
	@Override
	public void start(Stage loginStage) throws Exception {
		/*
		if (loadedContainer.equals(null)) {
			userList = new TreeMapUserStorageContainer();
			trailList = new TrailStorageContainer();
			Alert infoDialog = new Alert(AlertType.CONFIRMATION,
					"Saved data could not be found. The UserStorageContainer and TrailStorageContainer are empty.", ButtonType.OK);
			infoDialog.showAndWait();
			
		}
		 */
		loginForm();
		
	}
	public void loginForm() {
		BorderPane rootPane = new BorderPane();
		Button btnLogin = new Button("Login");
		Button btnCreateNewAccount = new Button("Create New Account");
		GridPane inputFields = new GridPane();
		HBox btnContainer = new HBox();
		Label lblUsername = new Label("Username:");
		Label lblPassword = new Label("Password:");
		PasswordField pwdField = new PasswordField();
		TextField usnField = new TextField();
		Stage loginStage = new Stage();
		
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (usnField.getText().isBlank() || pwdField.getText().isBlank()) {
					Alert infoDialog = new Alert(AlertType.ERROR,
							"Please ensure you have entered a username and password.", ButtonType.OK);
					infoDialog.showAndWait();
				} else {
					User authenticatedUser = userList.authenticateUser(usnField.getText(), pwdField.getText());
					if(authenticatedUser == null) {
						Alert infoDialog = new Alert(AlertType.ERROR,
								"No account associated with these credentials was found.", ButtonType.OK);
						infoDialog.showAndWait();
						return;
					} else {
						Alert infoDialog = new Alert(AlertType.INFORMATION,
								"Welcome to the Hiking App, " + authenticatedUser.getUsername() + " !", ButtonType.OK);
						infoDialog.showAndWait();
						mainForm();
					}
				}
			}
		});
		btnCreateNewAccount.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Button btnFinalCreateNewAccount = new Button("Create New Account");
				HBox firstNameInputContainer = new HBox();
				HBox lastNameInputContainer = new HBox();
				HBox phoneNumberInputContainer = new HBox();
				HBox buttonContainer = new HBox();
				HBox usernameInputContainer = new HBox();
				HBox passwordInputContainer = new HBox();
				Stage createNewAccountStage = new Stage();
				TextField firstNameInputField = new TextField();
				TextField lastNameInputField = new TextField();
				TextField phoneNumberInputField = new TextField();
				TextField usernameInputField = new TextField();
				TextField passwordInputField = new TextField();
				TilePane rootPane = new TilePane();
				
				btnFinalCreateNewAccount.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						if(firstNameInputField.getText().isEmpty() || lastNameInputField.getText().isEmpty() 
								|| phoneNumberInputField.getText().isEmpty()
								|| usernameInputField.getText().isEmpty() || passwordInputField.getText().isEmpty()) {
							Alert infoDialog = new Alert(AlertType.ERROR,
									"Please ensure all data fields have been filled properly and try again.", ButtonType.OK);
							infoDialog.showAndWait();
							return;
						} else {
							User newUser = new User(firstNameInputField.getText(),lastNameInputField.getText(),
									phoneNumberInputField.getText(), usernameInputField.getText(),
									passwordInputField.getText());
							userList.addUser(newUser);
							authenticatedUser = newUser;
							Alert infoDialog = new Alert(AlertType.INFORMATION,
									"Successfully created new account. Welcome, " + firstNameInputField.getText() + " ! You have been logged in.", ButtonType.OK);
							infoDialog.showAndWait();
							createNewAccountStage.close();
							loginStage.close();
							mainForm();
						}
					}
				});
				lastNameInputContainer.setPrefSize(200, 40);
				lastNameInputContainer.setPadding(new Insets(2.5, 5, 2.5, 5));
				lastNameInputField.setPromptText("Enter last name here");
				lastNameInputField.setFocusTraversable(false);
				lastNameInputField.setPrefSize(190, 35);
				btnFinalCreateNewAccount.setPrefSize(190, 32.5);
				buttonContainer.setPrefSize(200, 40);
				buttonContainer.setPadding(new Insets(2.5, 5, 5, 5));
				phoneNumberInputContainer.setPrefSize(200, 40);
				phoneNumberInputContainer.setPadding(new Insets(2.5, 5, 2.5, 5));
				phoneNumberInputField.setPromptText("Enter phone number here");
				phoneNumberInputField.setFocusTraversable(false);
				phoneNumberInputField.setPrefSize(190, 32.5);
				firstNameInputContainer.setPrefSize(200, 40);
				firstNameInputContainer.setPadding(new Insets(5, 5, 2.5, 5));
				firstNameInputField.setPromptText("Enter first name here");
				firstNameInputField.setFocusTraversable(false);
				firstNameInputField.setPrefSize(190, 32.5);
				
				usernameInputField.setPrefSize(190, 35);
				usernameInputField.setPromptText("Enter username here");
				usernameInputField.setFocusTraversable(false);
				passwordInputField.setPrefSize(190, 35);
				passwordInputField.setPromptText("Enter password here");
				passwordInputField.setFocusTraversable(false);
				usernameInputContainer.setPrefSize(200, 40);
				passwordInputContainer.setPrefSize(200, 40);
				usernameInputContainer.setPadding(new Insets(2.5,5,2.5,5));
				passwordInputContainer.setPadding(new Insets(2.5,5,5,5));
				usernameInputContainer.getChildren().add(usernameInputField);
				passwordInputContainer.getChildren().add(passwordInputField);
				firstNameInputContainer.getChildren().add(firstNameInputField);
				lastNameInputContainer.getChildren().add(lastNameInputField);
				phoneNumberInputContainer.getChildren().add(phoneNumberInputField);
				buttonContainer.getChildren().add(btnFinalCreateNewAccount);
				rootPane.getChildren().addAll(firstNameInputContainer, lastNameInputContainer,
						phoneNumberInputContainer,usernameInputContainer,passwordInputContainer, buttonContainer);
				Scene createNewAccountScene = new Scene(rootPane, 200, 240);
				createNewAccountStage.setScene(createNewAccountScene);
				createNewAccountStage.setResizable(false);
				createNewAccountStage.setTitle("Create New Account");
				createNewAccountStage.show();
			}
		});
		// these are in the order they are in for a reason, don't touch
		btnContainer.setPadding(new Insets(0, 0, 5, 26));
		btnContainer.setSpacing(5);
		btnLogin.setPrefWidth(50);
		inputFields.setHgap(5);
		inputFields.setVgap(5);
		inputFields.setPadding(new Insets(5, 0, 0, 5));
		inputFields.add(lblUsername, 0, 0);
		inputFields.add(usnField, 1, 0);
		inputFields.add(lblPassword, 0, 1);
		inputFields.add(pwdField, 1, 1);
		btnContainer.getChildren().addAll(btnLogin, btnCreateNewAccount);

		rootPane.setCenter(inputFields);
		rootPane.setBottom(btnContainer);
		Scene loginScene = new Scene(rootPane, 240, 100);
		loginStage.setScene(loginScene);
		loginStage.setTitle("Welcome to the Hiking App");
		loginStage.setResizable(false);
		loginStage.show();
	}
	public void mainForm() {
		Button btnStartHike = new Button("Start Hike");
		Button btnViewHistory = new Button("View History");
		Button btnEditAcctInfo = new Button("Edit Account Info");
		Button btnAdminFunctions = new Button("Admin Functions");
		GridPane buttonContainer = new GridPane();
		Stage mainFormStage = new Stage();
		
		btnStartHike.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mainFormStage.close();
				trailSearchForm();
			}
		});
		btnViewHistory.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mainFormStage.close();
				viewHistoryForm();
			}
		});
		btnEditAcctInfo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mainFormStage.close();
				editAcctInfoForm();
			}
		});
		btnAdminFunctions.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mainFormStage.close();
				adminFunctionsForm();
			}
		});
		mainFormStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent e) {
				loginForm();
			}
		});
		btnStartHike.setPrefSize(150, 100);
		btnViewHistory.setPrefSize(150, 100);
		btnEditAcctInfo.setPrefSize(150, 100);
		btnAdminFunctions.setPrefSize(150,100);
		buttonContainer.setPadding(new Insets(5,5,5,5));
		buttonContainer.setHgap(5);
		buttonContainer.setVgap(5);
		buttonContainer.setPrefSize(300, 215);
		buttonContainer.add(btnStartHike, 0, 0);
		buttonContainer.add(btnViewHistory, 1, 0);
		buttonContainer.add(btnEditAcctInfo, 0, 1);
		buttonContainer.add(btnAdminFunctions, 1, 1);
		
		Scene mainFormScene = new Scene(buttonContainer, 300, 215);
		mainFormStage.setScene(mainFormScene);
		mainFormStage.show();
	}
	public void trailSearchForm() {
		syncLists();
		TextField searchTerms = new TextField();
		Button btnSearch = new Button("Search..");
		HBox topSearchControlsContainer = new HBox();
		HBox searchLabelContainer = new HBox();
		VBox searchResultsListContainer = new VBox();
		BorderPane searchControls = new BorderPane();
		ListView <Trail> searchResults = new ListView <Trail> (driverListTrailSearchWindowResultsView);
		HBox bottomControlsContainer = new HBox();
		Button btnStartHike = new Button("Start Hike with Selected Trail");
		Label lblsearchResults = new Label("Search results will appear in the list below.");
		VBox parentContainer = new VBox();
		Stage trailSearchStage = new Stage();
		
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				 if(searchTerms.getText().isBlank()) {
					Alert infoDialog = new Alert(AlertType.ERROR, "Please enter search terms.", ButtonType.OK);
					infoDialog.showAndWait();
				} else {
					if(!driverListTrailSearchWindowResultsView.isEmpty()) {
						driverListTrailSearchWindowResultsView.clear();
					}
					LinkedList<Trail> searchResults = trailList.searchTrailList(searchTerms.getText());
					for(int i = 0; i < searchResults.size(); i++) {
						driverListTrailSearchWindowResultsView.add(searchResults.get(i));
					}
				}
			}
		});
		btnStartHike.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(driverListTrailSearchWindowResultsView.isEmpty()) {
					Alert infoDialog = new Alert(AlertType.ERROR, "There are no search results to select a trail from.", ButtonType.OK);
					infoDialog.showAndWait();
					return;
				} else {
					Object inputItem = searchResults.getSelectionModel().getSelectedItem();
					if(inputItem == null) {
						Alert infoDialog = new Alert(AlertType.ERROR, "No trail is selected. Please select a trail by highighting it.", ButtonType.OK);
						infoDialog.showAndWait();
						return;
					} else {
						if(inputItem instanceof Trail) {
							Trail selectedTrail = (Trail)inputItem;
							trailSearchStage.close();
							hikingForm(selectedTrail);
						}
					}	
				}
			}
		});
		
		topSearchControlsContainer.setPrefSize(620,35);
		topSearchControlsContainer.setPadding(new Insets(5,5,5,5));
		topSearchControlsContainer.setSpacing(5);
		searchTerms.setPrefSize(535, 25);
		btnSearch.setPrefSize(70, 25);
		searchTerms.setPromptText("Enter your search terms here...");
		topSearchControlsContainer.getChildren().addAll(searchTerms, btnSearch);
		
		searchLabelContainer.setPrefSize(620, 35);
		searchLabelContainer.setPadding(new Insets(5,5,5,5));
		searchLabelContainer.getChildren().add(lblsearchResults);
		
		searchControls.setPrefSize(620, 70);
		searchControls.setTop(topSearchControlsContainer);
		searchControls.setBottom(searchLabelContainer);
		
		searchResultsListContainer.setPrefSize(620, 535);
		searchResultsListContainer.setPadding(new Insets(0,5,0,5));
		searchResults.setPrefSize(610, 535);
		searchResultsListContainer.getChildren().add(searchResults);
		
		bottomControlsContainer.setPrefSize(620, 60);
		bottomControlsContainer.setPadding(new Insets(5,5,5,5));
		bottomControlsContainer.setSpacing(10);
		btnStartHike.setPrefSize(620, 50);
		bottomControlsContainer.getChildren().addAll(btnStartHike);
		
		parentContainer.setPrefSize(620, 665);
		parentContainer.getChildren().addAll(searchControls,searchResultsListContainer,bottomControlsContainer);
		
		Scene checkoutScene = new Scene(parentContainer, 620, 665);
		trailSearchStage.setScene(checkoutScene);
		trailSearchStage.setTitle("Select a trail to hike.");
		trailSearchStage.setResizable(false);
		trailSearchStage.show();
		
	}
	public void hikingForm(Trail selectedTrail) {
		Button btnSave = new Button("Save This Hike");
		HBox timestampInputContainer = new HBox();
		HBox distanceInputContainer = new HBox();
		HBox durationInputContainer = new HBox();
		HBox buttonContainer = new HBox();
		HBox averagePaceInputContainer = new HBox();
		Stage hikingFormStage = new Stage();
		TextField timestampInputField = new TextField();
		TextField distanceInputField = new TextField();
		TextField durationInputField = new TextField();
		TextField averagePaceInputField = new TextField();
		TilePane rootPane = new TilePane();
		
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(timestampInputField.getText().isEmpty() || distanceInputField.getText().isEmpty() 
						|| durationInputField.getText().isEmpty()
						|| averagePaceInputField.getText().isEmpty()) {
					Alert infoDialog = new Alert(AlertType.ERROR,
							"Please ensure all data fields have been filled properly and try again.", ButtonType.OK);
					infoDialog.showAndWait();
					return;
				} else {
					HikingHistoryEntry newEntry = new HikingHistoryEntry(selectedTrail, timestampInputField.getText(), Double.valueOf(distanceInputField.getText()),
							durationInputField.getText(), Double.valueOf(averagePaceInputField.getText()));
					authenticatedUser.addHistoryEntry(newEntry);
					syncLists();
					Alert infoDialog = new Alert(AlertType.INFORMATION,
							"Successfully entered this hike into your history.", ButtonType.OK);
					infoDialog.showAndWait();
					hikingFormStage.close();
					mainForm();
				}
			}
		});
		distanceInputContainer.setPrefSize(200, 40);
		distanceInputContainer.setPadding(new Insets(2.5, 5, 2.5, 5));
		distanceInputField.setPromptText("Enter distance here");
		distanceInputField.setFocusTraversable(false);
		distanceInputField.setPrefSize(190, 35);
		btnSave.setPrefSize(190, 32.5);
		buttonContainer.setPrefSize(200, 40);
		buttonContainer.setPadding(new Insets(2.5, 5, 5, 5));
		durationInputContainer.setPrefSize(200, 40);
		durationInputContainer.setPadding(new Insets(2.5, 5, 2.5, 5));
		durationInputField.setPromptText("Enter duration here");
		durationInputField.setFocusTraversable(false);
		durationInputField.setPrefSize(190, 32.5);
		timestampInputContainer.setPrefSize(200, 40);
		timestampInputContainer.setPadding(new Insets(5, 5, 2.5, 5));
		timestampInputField.setPromptText("Enter timestamp here");
		timestampInputField.setFocusTraversable(false);
		timestampInputField.setPrefSize(190, 32.5);
		averagePaceInputField.setPrefSize(190, 35);
		averagePaceInputField.setPromptText("Enter average pace here");
		averagePaceInputField.setFocusTraversable(false);
		averagePaceInputContainer.setPrefSize(200, 40);
		averagePaceInputContainer.setPadding(new Insets(2.5,5,2.5,5));
		averagePaceInputContainer.getChildren().add(averagePaceInputField);
		
		timestampInputContainer.getChildren().add(timestampInputField);
		distanceInputContainer.getChildren().add(distanceInputField);
		durationInputContainer.getChildren().add(durationInputField);
		buttonContainer.getChildren().add(btnSave);
		rootPane.getChildren().addAll(timestampInputContainer, distanceInputContainer,durationInputContainer,averagePaceInputContainer,buttonContainer);
		Scene hikingFormScene = new Scene(rootPane, 200, 200);
		hikingFormStage.setScene(hikingFormScene);
		hikingFormStage.setResizable(false);
		hikingFormStage.setTitle("Enter Hike Info");
		hikingFormStage.show();
	}
	public void viewHistoryForm() {
		syncLists();
		ListView<HikingHistoryEntry> historyListView = new ListView<HikingHistoryEntry>(driverListHistoryWindowResultsView);
		Button btnDeleteSelected = new Button("Delete Selected Entry");
		Label listViewLbl = new Label("Your hiking history will appear below.");
		HBox listViewLblContainer = new HBox();
		HBox buttonContainer = new HBox();
		HBox listViewContainer = new HBox();
		VBox parentContainer = new VBox();
		Stage historyFormStage = new Stage();
		
		btnDeleteSelected.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(driverListHistoryWindowResultsView.isEmpty()) {
					Alert infoDialog = new Alert(AlertType.ERROR, "The list of entries is empty.", ButtonType.OK);
					infoDialog.showAndWait();
					return;
				} else {
					Object inputItem = historyListView.getSelectionModel().getSelectedItem();
					if(inputItem == null) {
						Alert infoDialog = new Alert(AlertType.ERROR, "No entry is selected. Please select an entry by highighting it.", ButtonType.OK);
						infoDialog.showAndWait();
						return;
					} else {
						if(inputItem instanceof HikingHistoryEntry) {
							HikingHistoryEntry selectedEntry = (HikingHistoryEntry)inputItem;
							authenticatedUser.deleteHistoryEntry(selectedEntry);
							syncLists();
							Alert infoDialog = new Alert(AlertType.INFORMATION, "You have successfully removed this entry.", ButtonType.OK);
							infoDialog.showAndWait();
						}
					}
				}
			}
		});
		historyFormStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				mainForm();
			}
		});
		listViewLblContainer.setPrefSize(410, 35);
		listViewLblContainer.setPadding(new Insets(5,5,5,5));
		listViewLblContainer.getChildren().add(listViewLbl);
		
		historyListView.setPrefSize(400,300);
		listViewContainer.setPrefSize(410, 310);
		listViewContainer.setPadding(new Insets(0,5,5,5));
		listViewContainer.getChildren().add(historyListView);
		
		buttonContainer.setPrefSize(410,35);
		btnDeleteSelected.setPrefSize(250, 30);
		buttonContainer.setPadding(new Insets(0,5,5,80));
		buttonContainer.getChildren().add(btnDeleteSelected);
		
		parentContainer.setPrefSize(410, 380);
		parentContainer.getChildren().addAll(listViewLblContainer,listViewContainer, buttonContainer);
		
		Scene transactionHistoryScene = new Scene(parentContainer, 410, 380);
		
		historyFormStage.setScene(transactionHistoryScene);
		historyFormStage.setTitle("Hiking History");
		historyFormStage.setResizable(false);
		historyFormStage.show();
	}
	public void editAcctInfoForm() {
		Button btnSaveInfo = new Button("Save Info");
		HBox firstNameInputContainer = new HBox();
		HBox lastNameInputContainer = new HBox();
		HBox phoneNumberInputContainer = new HBox();
		HBox buttonContainer = new HBox();
		HBox usernameInputContainer = new HBox();
		HBox passwordInputContainer = new HBox();
		Stage editAcctInfoStage = new Stage();
		TextField firstNameInputField = new TextField();
		TextField lastNameInputField = new TextField();
		TextField phoneNumberInputField = new TextField();
		TextField usernameInputField = new TextField();
		TextField passwordInputField = new TextField();
		TilePane rootPane = new TilePane();
		
		btnSaveInfo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(firstNameInputField.getText().isEmpty() || lastNameInputField.getText().isEmpty() 
						|| phoneNumberInputField.getText().isEmpty()
						|| usernameInputField.getText().isEmpty() || passwordInputField.getText().isEmpty()) {
					Alert infoDialog = new Alert(AlertType.ERROR,
							"Please ensure all data fields have been filled properly and try again.", ButtonType.OK);
					infoDialog.showAndWait();
					return;
				} else {
					User newUser = new User(firstNameInputField.getText(),lastNameInputField.getText(),
							phoneNumberInputField.getText(), usernameInputField.getText(),
							passwordInputField.getText(), authenticatedUser.getHistoryList());
					userList.deleteUser(authenticatedUser);
					userList.addUser(newUser);
					authenticatedUser = newUser;
					Alert infoDialog = new Alert(AlertType.INFORMATION,
							"Successfully updated account info.", ButtonType.OK);
					infoDialog.showAndWait();
					editAcctInfoStage.close();
					mainForm();
				}
			}
		});
		lastNameInputContainer.setPrefSize(200, 40);
		lastNameInputContainer.setPadding(new Insets(2.5, 5, 2.5, 5));
		lastNameInputField.setPromptText("Enter last name here");
		lastNameInputField.setFocusTraversable(false);
		lastNameInputField.setPrefSize(190, 35);
		btnSaveInfo.setPrefSize(190, 32.5);
		buttonContainer.setPrefSize(200, 40);
		buttonContainer.setPadding(new Insets(2.5, 5, 5, 5));
		phoneNumberInputContainer.setPrefSize(200, 40);
		phoneNumberInputContainer.setPadding(new Insets(2.5, 5, 2.5, 5));
		phoneNumberInputField.setPromptText("Enter phone number here");
		phoneNumberInputField.setFocusTraversable(false);
		phoneNumberInputField.setPrefSize(190, 32.5);
		firstNameInputContainer.setPrefSize(200, 40);
		firstNameInputContainer.setPadding(new Insets(5, 5, 2.5, 5));
		firstNameInputField.setPromptText("Enter first name here");
		firstNameInputField.setFocusTraversable(false);
		firstNameInputField.setPrefSize(190, 32.5);
		
		usernameInputField.setPrefSize(190, 35);
		usernameInputField.setPromptText("Enter username here");
		usernameInputField.setFocusTraversable(false);
		passwordInputField.setPrefSize(190, 35);
		passwordInputField.setPromptText("Enter password here");
		passwordInputField.setFocusTraversable(false);
		usernameInputContainer.setPrefSize(200, 40);
		passwordInputContainer.setPrefSize(200, 40);
		usernameInputContainer.setPadding(new Insets(2.5,5,2.5,5));
		passwordInputContainer.setPadding(new Insets(2.5,5,5,5));
		usernameInputContainer.getChildren().add(usernameInputField);
		passwordInputContainer.getChildren().add(passwordInputField);
		firstNameInputContainer.getChildren().add(firstNameInputField);
		lastNameInputContainer.getChildren().add(lastNameInputField);
		phoneNumberInputContainer.getChildren().add(phoneNumberInputField);
		buttonContainer.getChildren().add(btnSaveInfo);
		rootPane.getChildren().addAll(firstNameInputContainer, lastNameInputContainer,
				phoneNumberInputContainer,usernameInputContainer,passwordInputContainer, buttonContainer);
		Scene createNewAccountScene = new Scene(rootPane, 200, 240);
		editAcctInfoStage.setScene(createNewAccountScene);
		editAcctInfoStage.setResizable(false);
		editAcctInfoStage.setTitle("Create New Account");
		editAcctInfoStage.show();
	}
	public void adminFunctionsForm() {
		Alert infoDialog = new Alert(AlertType.INFORMATION,
				"Click OK to randomly populate the userList and trailList with data.", ButtonType.OK);
		infoDialog.showAndWait();
		populateListsRandomly();
		mainForm();
	}
}