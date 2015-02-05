package it.cnr.itd.uni2014.javafx.bind.basic;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainBinding03 extends Application {
	@Override
	public void start(Stage stage) {
		BorderPane root = new BorderPane();
		Slider slider = new Slider();
		slider.setMax(1);
		TextField t = new TextField();
		t.setPrefSize(100, 20);
		Scene scene = new Scene(root, 500, 500, Color.BLACK);
		final Rectangle r = new Rectangle(25, 25, 250, 250);
		r.setFill(Color.BLUE);
		root.setCenter(r);
		root.setBottom(slider);
		root.setRight(t);
		r.scaleXProperty().bind(slider.valueProperty());
		r.scaleYProperty().bind(slider.valueProperty());
		t.textProperty().bindBidirectional(slider.valueProperty(),
				new DecimalFormat());
		stage.setTitle("JavaFX Scene Graph Demo");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
