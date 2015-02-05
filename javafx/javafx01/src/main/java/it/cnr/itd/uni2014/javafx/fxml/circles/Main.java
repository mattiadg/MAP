package it.cnr.itd.uni2014.javafx.fxml.circles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("FXML TableView Example");
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource(
				"circles.fxml"));
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
