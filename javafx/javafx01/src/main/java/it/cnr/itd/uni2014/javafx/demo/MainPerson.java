package it.cnr.itd.uni2014.javafx.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainPerson extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("FXML TableView Example");
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource(
				"person.fxml"));
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
