package it.cnr.itd.uni2014.javafx.bind.exercise1;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainBinding03 extends Application {
	@Override
	public void start(Stage stage) {
		Slider s1 = new Slider();
		s1.setMax(50);
		s1.prefWidth(150);
		final Circle c1 = new Circle();
		c1.setFill(Color.BLUE);
		c1.radiusProperty().bind(s1.valueProperty());
		Slider s2 = new Slider();
		s2.setMax(50);
		s2.prefWidth(150);
		final Circle c2 = new Circle();
		c2.setFill(Color.BLUE);
		c2.radiusProperty().bind(s2.valueProperty());
		final DoubleBinding totalArea = new DoubleBinding() {
			{
				super.bind(c1.radiusProperty(), c2.radiusProperty());
			}

			@Override
			protected double computeValue() {
				return Math.PI * Math.pow(c1.radiusProperty().get(), 2)
						+ Math.PI * Math.pow(c2.radiusProperty().get(), 2);
			}
		};
		DoubleBinding radius = new DoubleBinding() {
			{
				super.bind(totalArea);
			}

			@Override
			protected double computeValue() {
				return Math.sqrt(totalArea.get() / Math.PI);
			}
		};
		final Circle c3 = new Circle();
		c3.setFill(Color.RED);
		c3.radiusProperty().bind(radius);
		TextField t = new TextField();
		t.setPrefSize(200, 20);
		// t.textProperty().bind(radius.asString());
		BorderPane root = new BorderPane();
		GridPane grid = new GridPane();
		grid.add(s1, 0, 0);
		grid.add(c1, 0, 1);
		grid.add(s2, 1, 0);
		grid.add(c2, 1, 1);
		grid.add(t, 2, 0);
		grid.add(c3, 2, 1);
		root.setCenter(grid);
		Scene scene = new Scene(root, 500, 500, Color.BLACK);
		stage.setTitle("JavaFX Scene Graph Demo");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
