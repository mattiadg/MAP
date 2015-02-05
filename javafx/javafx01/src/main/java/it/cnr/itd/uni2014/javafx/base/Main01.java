package it.cnr.itd.uni2014.javafx.base;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main01 extends Application {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500, Color.AQUAMARINE);
		stage.setTitle("JavaFX Scene Graph Demo");
		stage.setScene(scene);
		stage.show();
	}
}
