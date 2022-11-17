package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class GameController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToGameScreen(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Game.fxml"));
		stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToHomeScreen(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void initializeGame() {
		
	}

}
